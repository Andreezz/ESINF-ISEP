import javax.swing.JOptionPane;

public class Fatorial {
    public int fatorialRecursivo(int num) {
        if (num == 0)
            return 1;
        return num * fatorialRecursivo(num - 1);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("DIGITE UM VALOR"));
        Fatorial B = new Fatorial();
        n = B.fatorialRecursivo(n);
        JOptionPane.showMessageDialog(null, "o fatorial é: " + n);
    }
}
