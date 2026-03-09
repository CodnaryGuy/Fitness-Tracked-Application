//package com.codna.fitness.security;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//
//@Component
//public class AuthTokenFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private JwtUtilsDemo jwtUtilsDemo;
//
////    @Autowired
////    private UserDetailsService userDetailsService;
//
//    /**
//     * Internal method used for custom filter
//     * @param request
//     * @param response
//     * @param filterChain
//     * @throws ServletException
//     * @throws IOException
//     */
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//        System.out.println("AuthTokenFilter Called");
//        try{
//            String jwt = parseJwt(request);
//            if (jwt != null && jwtUtilsDemo.validateJwtToken(jwt)){
//                System.out.println("TOKEN THERE: " + jwt);
//                String username = jwtUtilsDemo.getUsernameFromToken(jwt);
////                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//
//                Claims claims = jwtUtilsDemo.getAllClaims(jwt);
//                List<String> roles = claims.get(roles, List.class);
//                List<GrantedAuthority> authorities = List.of();
//                if (roles != null){
//                    authorities = roles.stream()
//                            .map(role ->(GrantedAuthority) new SimpleGrantedAuthority(role))
//                            .toList();
//                }
//
//                // created one Authentication object to store the object in SecurityContext
//                UsernamePasswordAuthenticationToken authentication =
//                        new UsernamePasswordAuthenticationToken(username,
//                                null,
//                                authorities);
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//    private String parseJwt(HttpServletRequest request){
//        String jwt = jwtUtilsDemo.getJwtFromHeader(request);
//        return jwt;
//    }
//}
