package com.testproject.swp.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.testproject.swp.entity.User;
import com.testproject.swp.model.token.TokenPayLoad;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTTokenUtil {
    private final String secret = "TUNG_TV";

    public String generateToken(User user, long expiredDate) {

        Map<String, Object> claims = new HashMap<>();

        TokenPayLoad tokenPayLoad = TokenPayLoad.builder()
                .userID(user.getUserID())
                .email(user.getEmail())
                .build();

        claims.put("payload", tokenPayLoad);

        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredDate * 1000))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public TokenPayLoad getTokenPayLoad(String token) {
        // biểu thức lamda
        return getClaimsFromToken(token, (Claims claim) -> {
            Map<String, Object> mapResult = (Map<String, Object>) claim.get("payload");
            return TokenPayLoad.builder().userID((int) mapResult.get("userID")).email((String) mapResult.get("email"))
                    .build();
        });
    }

    private <T> T getClaimsFromToken(String token, Function<Claims, T> ClaimsResolver) {
        final Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return ClaimsResolver.apply(claims);
    }

    public boolean validate(String token, User user) {
        TokenPayLoad tokenPayLoad = getTokenPayLoad(token);

        return tokenPayLoad.getUserID() == user.getUserID() &&
                tokenPayLoad.getEmail().equals(user.getEmail())
                && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        Date expiredDate = getClaimsFromToken(token, Claims::getExpiration);
        return expiredDate.before(new Date());
    }

}
