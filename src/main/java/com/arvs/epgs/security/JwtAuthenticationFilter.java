package com.arvs.epgs.security;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.crypto.SecretKey;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.arvs.epgs.service.UserService;
import com.arvs.epgs.service.UserServiceImpl;
import com.arvs.epgs.util.SecurityConstants;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!= null) {
			String username =  authentication.getName();
			
			SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));

            String jwt_token = Jwts.builder()
                    .setIssuer("javainfinite")
                    .setExpiration(new Date((new Date()).getTime() + 300000))
                    .setSubject("javainfinite_token")
                    .claim("firstname", username)
                    .claim("authorities", getStudentRoles((List<GrantedAuthority>) authentication.getAuthorities()))
                    .signWith(key)
                    .compact();

            if (request.getHeader(SecurityConstants.REFRESH_HEADER) == null) {

                String refresh_token = Jwts.builder()
                        .setIssuer("javainfinite")
                        .setExpiration(new Date((new Date()).getTime() + 3000000))
                        .setSubject("javainfinite_token")
                        .claim("firstname", username)
                        .claim("authorities", getStudentRoles((List<GrantedAuthority>) authentication.getAuthorities()))
                        .signWith(key)
                        .compact();

                response.setHeader(SecurityConstants.REFRESH_HEADER, refresh_token);
                System.out.println("Refresh Token successfully generated: {}"+ refresh_token);
            }
            response.setHeader(SecurityConstants.AUTHORIZATION_HEADER, jwt_token);
            System.out.println("Token successfully generated: {}"+jwt_token);
        }
		filterChain.doFilter(request, response);
    }

    private String getStudentRoles(List<GrantedAuthority> collection) {
        Set<String> authoritiesSet = new HashSet<>();
        for (GrantedAuthority authority : collection) {
            authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
    }
		/*
		 * final String authHeader = request.getHeader("Authorization"); final String
		 * jwt; String username = null; if(authHeader== null ||
		 * !authHeader.startsWith("Bearer ")) { filterChain.doFilter(request, response);
		 * //return; } jwt ="";// authHeader.substring(7); username =
		 * jwtTokenHelper.getUsernameFromToken(jwt); if(username ==null &&
		 * SecurityContextHolder.getContext().getAuthentication()==null) { UserDetails
		 * userDetails = this.userDetailsService.loadUserByUsername(username);
		 * if(jwtTokenHelper.isTokenvalid(username, userDetails)) {
		 * UsernamePasswordAuthenticationToken passwordAuthenticationToken = new
		 * UsernamePasswordAuthenticationToken(userDetails, null,
		 * userDetails.getAuthorities()); passwordAuthenticationToken.setDetails(new
		 * WebAuthenticationDetailsSource().buildDetails(request));
		 * SecurityContextHolder.getContext().setAuthentication(
		 * passwordAuthenticationToken); } filterChain.doFilter(request, response); }
		 */
		
		// TODO Auto-generated method stub
		/*String requestToken = request.getHeader("Authorization");
		System.out.println(requestToken);
		String username = null;
		String token = null;
		if(requestToken!=null && requestToken.startsWith("Bearer")) {
			token = requestToken.substring(7);
			try {
			username = this.jwtTokenHelper.getUsernameFromToken(token);
			}
			catch(IllegalArgumentException illAE) {
				System.out.println("Unable to get Token !");
				
			}
			catch(ExpiredJwtException ex) {
				System.out.println("Jwt token has expired ");
			}
			catch(MalformedJwtException mJe) {
				System.out.println("invalid Jwt ");
			}
		}
		else
		{
			System.out.println("Jwt token does not started with Bearer");
		}
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication()==null) {
			
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(this.jwtTokenHelper.validateToken(token, userDetails)) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
						new UsernamePasswordAuthenticationToken( userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}else {
				System.out.println("invalid Jwt token");
			}
			
		}else {
			System.out.println("username is null or contextis not null");
		}
		filterChain.doFilter(request, response);
		*/
	

}
