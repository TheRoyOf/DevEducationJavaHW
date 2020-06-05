package shop;

public class Sequrity {
    public static boolean CheckClient(Client client)
    {
        return client.getCheck().getToken().equals(TokenGenerator.generateToken(client.getGoods()));
    }
}
