package com.arvs.epgs.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenHelper {

	public static final String secret = "helllo12345678900987654321234567890";

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts// parser().setSigningKey(secret).parseClaimsJws(token).getBody();
				.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
	}

	private Key getSignInKey() {
		// TODO Auto-generated method stub
		byte[] keyBytes = Decoders.BASE64.decode(secret);

		return Keys.hmacShaKeyFor(keyBytes);
	}

	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(), userDetails);
	}

	public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {

		return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
				.signWith(getSignInKey(), SignatureAlgorithm.HS256).compact();

	}

	public boolean isTokenvalid(String token, UserDetails userDetails) {

		final String userName = getUsernameFromToken(token);
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));

	}
	public Date getExpirationDateFromToken(String token) { return
			  getClaimFromToken(token,Claims::getExpiration); 
	}
	
	private boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	/*
	 * public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	 * 
	 * private String secret = "jwtTokenKey";
	 * 
	 * public String getUsernameFromToken(String token) { return
	 * getClaimFromToken(token,Claims::getSubject); }
	 * 
	 * public Date getExpirationDateFromToken(String token) { return
	 * getClaimFromToken(token,Claims::getExpiration); }
	 * 
	 * public <T> T getClaimFromToken(String token, Function<Claims,T>
	 * claimResolver) { final Claims claims = getAllClaimsFromToken(token); return
	 * claimResolver.apply(claims); }
	 * 
	 * 
	 * private Claims getAllClaimsFromToken(String token) { return
	 * Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody(); }
	 * 
	 * private boolean isTokenExpired(String token) { final Date expiration =
	 * getExpirationDateFromToken(token); return expiration.before(new Date()); }
	 * 
	 * public String generateToken(UserDetails userDetails) { Map<String,Object>
	 * claims = new HashMap<>(); return
	 * doGenerateToken(claims,userDetails.getUsername());
	 * 
	 * 
	 * }
	 * 
	 * private String doGenerateToken(Map<String, Object> claims, String subject) {
	 * // TODO Auto-generated method stub return
	 * Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new
	 * Date(System.currentTimeMillis()) ).setExpiration(new
	 * Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY * 1000))
	 * .signWith(SignatureAlgorithm.HS512, secret).compact();
	 * 
	 * }
	 * 
	 * public Boolean validateToken(String token,UserDetails userDetails) {
	 * 
	 * final String userName = getUsernameFromToken(token); return
	 * (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	 * 
	 * }
	 */
}
