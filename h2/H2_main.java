package h2;

public class H2_main {
    public static void main(String[] args) {
        Spielbrett brett = new Spielbrett(3);

        brett.getBrett()[0][0] = new Feld(false, 'L');
        brett.getBrett()[0][1] = new Feld(true, 'R');
        brett.getBrett()[0][2] = new Feld(false, 'L');

        brett.getBrett()[1][0] = new Feld(false, 'L');
        brett.getBrett()[1][1] = new Feld(true, 'R');
        brett.getBrett()[1][2] = new Feld(false, 'U');

        brett.getBrett()[2][0] = new Feld(false, 'L');
        brett.getBrett()[2][1] = new Feld(false, 'U');
        brett.getBrett()[2][2] = new Feld(false, 'U');

        Spielstein s = new Spielstein(brett, 2, 2);
        s.go(7);
    }
}
