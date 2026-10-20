import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class CounterApp extends JFrame {
    private int count = 0;
    private final JLabel label = new JLabel("0", JLabel.CENTER);

    public CounterApp() {
        setTitle("Space Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 180);
        setLocationRelativeTo(null);

        label.setFont(new Font("SansSerif", Font.BOLD, 48));
        add(label, BorderLayout.CENTER);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (count < 10) {
                        count++;
                    }
                    label.setText(String.valueOf(count));
                }
            }
        });

        setFocusable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CounterApp app = new CounterApp();
            app.requestFocusInWindow();
        });
    }
}
