package shop;

public class TokenGenerator {
    public static String generateToken(Goods goods){
        StringBuilder token = new StringBuilder();
        token.append(goods.getName());
        token.insert(0, goods.getPrice());
        token.append(goods.hashCode());
        return token.toString();
    }
}
