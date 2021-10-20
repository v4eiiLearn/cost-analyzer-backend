package ru.vevteev.costanalyzerbackend.config

import com.nimbusds.jose.shaded.json.JSONArray
import com.nimbusds.jose.shaded.json.JSONObject
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter
import ru.vevteev.costanalyzerbackend.exception.JwtNullException

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfiguration : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
            .authorizeRequests {
                it.antMatchers("/api/anonymous/**").permitAll()
                    .anyRequest().authenticated()
            }
            .oauth2ResourceServer {
                it.jwt { jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwtAuthenticationConverter()) }
            }
    }

    @Bean
    fun jwtAuthenticationConverter(): Converter<Jwt, AbstractAuthenticationToken> {
        val jwtAuthenticationConverter = JwtAuthenticationConverter()
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter())

        return jwtAuthenticationConverter
    }

    @Bean
    fun jwtGrantedAuthoritiesConverter(): Converter<Jwt, Collection<GrantedAuthority>> {
        val delegate = JwtGrantedAuthoritiesConverter()

        return object : Converter<Jwt, Collection<GrantedAuthority>> {
            override fun convert(jwt: Jwt): Collection<GrantedAuthority> {
                val grantedAuthorities = delegate.convert(jwt) ?: throw JwtNullException()

                val realmAccessClaim = jwt.getClaim<JSONObject>("realm_access") ?: return grantedAuthorities

                val roles: JSONArray = realmAccessClaim["roles"] as JSONArray

                val keycloakAuthorities = roles.map { SimpleGrantedAuthority("ROLE_$it") }.toList()
                grantedAuthorities.addAll(keycloakAuthorities)

                return grantedAuthorities
            }
        }
    }
}