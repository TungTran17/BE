// package com.testproject.swp.util;

// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.stereotype.Component;

// import com.testproject.swp.entity.User;
// import com.testproject.swp.model.dto.user.UserDTOLoginRequest;

// @Component
// public class JWTTokenUtil {
//         private final String secret = "TUNG_TV";

//     public String generateToken(User user, long expiredDate) {
//         Map<String, Object> claims = new HashMap<>();

//         UserDTOLoginRequest userDTOLoginRequest = UserDTOLoginRequest.builder().user_email(user.getUser_email()).user_password(user.getUser_password()).build();

//         claims.put("payload", userDTOLoginRequest);

//         return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis()))
//                 .setExpiration(new Date(System.currentTimeMillis() + expiredDate * 1000))
//                 .signWith(SignatureAlgorithm.HS256, secret).compact();
//     }

//     public UserDTOLoginRequest getTokenPayLoad(String token) {

//         return getClaimsFromToken(token, (Claims claim) -> {
//             Map<String, Object> mapResult = (Map<String, Object>) claim.get("payload");
//             return TokenPayload.builder().userID((int) mapResult.get("userID")).email((String) mapResult.get("email"))
//                     .build();
//         });
//     }

//     private <T> T getClaimsFromToken(String token, Function<Claims, T> ClaimsResolver) {
//         final Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//         return ClaimsResolver.apply(claims);
//     }

//     public boolean validate(String token, Account user) {
//         UserDTOLoginRequest tokenPayload = getTokenPayLoad(token);
        
//         return tokenPayload.getUserID() == user.getId() && tokenPayload.getEmail().equals(user.getEmail()) && !isTokenExpired(token);
//     }

//     private boolean isTokenExpired(String token) {
//         Date expiredDate = getClaimsFromToken(token, Claims::getExpiration);
//         return expiredDate.before(new Date());
//     }

// }
