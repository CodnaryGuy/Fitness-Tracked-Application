//package com.codna.fitness.security;
//
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import java.security.Key;
//import java.util.Date;
//
///**
// * It used for jwt related helper methods
// * token issue, validate, token information
// */
//@Component
//public class JwtUtilsDemo {
//
//    private String jwtSecret = "YS1zdHJpbmctc2VjcmV0LWF0LWxlYXN0LTI1Ni1iaXRzLWxvbmc=";
//    private int jwtExpirationMs = 172800000; // 48 hours
//
//    /**
//     * this method is used to retrieve the Jwt from header
//     * @param request
//     * @return
//     */
//    public String getJwtFromHeader(HttpServletRequest request){
//        String bearerToken = request.getHeader("Authorization");
//        if (bearerToken != null && bearerToken.startsWith("Bearer "))
//            return bearerToken.substring(7);
//
//        return null;
//    }
//
//    /**
//     * Used to Issue the TOKEN from username
//     * @param userDetails
//     * @return
//     */
//    public String generateTokenFromUsername(UserDetails userDetails){
//        String userName = userDetails.getUsername();
//
//        return Jwts.builder()
//                .subject(userName)
//                .claim("roles", userDetails.getAuthorities().stream()
//                        .map(GrantedAuthority::getAuthority)
//                        .toList())
//                .issuedAt(new Date())
//                .expiration(new Date(new Date().getTime() + jwtExpirationMs))
//                .signWith(key())
//                .compact();
//    }
//
//    /**
//     * Used to Validate the Token
//     * @param jwtToken
//     * @return
//     */
//    public boolean validateJwtToken(String jwtToken){
//        try{
//            Jwts.parser().verifyWith((SecretKey)Key()).build
//                    .parseSignedClaims(jwtToken);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return true;
//    }
//
//    /**
//     * Returned the key of BASE64 decoded key
//     * @return
//     */
//    private Key key(){
//        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
//    }
//
//    /**
//     * To get the Username from token
//     * @param jwt
//     * @return
//     */
//    public String getUsernameFromToken(String jwt) {
//        return Jwts.parser().verifyWith(key())
//                .build().parseSignedClaims(jwt)
//                .getPayload().getSubject();
//    }
//
//    /**
//     * To get the claims from token
//     * @param jwt
//     * @return
//     */
//    public Claims getAllClaims(String jwt) {
//        return Jwts.parser().verifyWith(key())
//                .build().parseSignedClaims(jwt)
//                .getPayload();
//    }
//}
