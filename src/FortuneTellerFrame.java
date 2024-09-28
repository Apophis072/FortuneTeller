import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl;
    JPanel iconPnl;  // Top
    JPanel middlePnl; // Center
    JPanel bottomPnl; // Bottom

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel titleLbl;

    JButton helloBtn;
    JButton quitBtn;
    String randomElement;
    int randomIndex;
    String lastFortune;
    int fortuneNum = 0;

    public FortuneTellerFrame()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.width * 0.75);
        int height = (int) (screenSize.height * 0.75);

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createMiddlePanel();
        mainPnl.add(middlePnl, BorderLayout.CENTER);

        createBottomPanel();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createIconPanel()
    {
        iconPnl = new JPanel();
        ImageIcon icon = new ImageIcon("src/Fortuneteller.png");
        titleLbl = new JLabel("Fortune Teller!!!", icon, JLabel.CENTER);
        titleLbl.setFont(new Font("Font", Font.BOLD, 48));
        iconPnl.add(titleLbl);
    }

    private void createMiddlePanel()
    {
        middlePnl = new JPanel();
        displayTA = new JTextArea(10, 25);
        Font font = new Font("Verdana", Font.BOLD, 20);
        displayTA.setFont(font);
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        middlePnl.add(scroller);
    }


    private void createBottomPanel()
    {

        ArrayList<String> fortunes = new ArrayList<>();
        fortunes.add(0,"Your road to glory will be rocky but fulfilling");
        fortunes.add(1, "An important person will offer you support");
        fortunes.add(2, "Any decision you have to make tomorrow is a good decision");
        fortunes.add(3, "If you look back, you’ll soon be going that way!");
        fortunes.add(4, "Be on the alert to recognize your prime at whatever time of your life it might occur.");
        fortunes.add(5, "Soon life will become more interesting.");
        fortunes.add(6, "You will receive a message from the universe.");
        fortunes.add(7, "You will laugh until you cry.");
        fortunes.add(8, "A bird will sing just for you.");
        fortunes.add(9,"Someone will compliment you today.");
        fortunes.add(10, "An exciting opportunity awaits you.");
        fortunes.add(11, "You will have a great day!");

        Random rand = new Random();

        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1, 2));
        helloBtn = new JButton("Ready my fortune");
        helloBtn.setFont(new Font("Arial", Font.ITALIC, 20));
        helloBtn.setBackground(Color.BLUE);
        helloBtn.setForeground(Color.PINK);
        helloBtn.addActionListener((ActionEvent ae) ->
        {
            if (fortuneNum == 0)
            {
                randomIndex = rand.nextInt(fortunes.size());
                randomElement = fortunes.get(randomIndex);
                displayTA.append("Fortune: " + randomElement + "\n");
                lastFortune = randomElement;
                fortuneNum = 1;
            }
            else
            {
                randomIndex = rand.nextInt(fortunes.size());
                String randomElement = fortunes.get(randomIndex);
                if (lastFortune != randomElement)
                {
                    displayTA.append("Fortune: " + randomElement + "\n");
                }
                else
                {
                    do
                    {
                        randomIndex = rand.nextInt(fortunes.size());
                        randomElement = fortunes.get(randomIndex);
                    }while (lastFortune == randomElement);
                }
            }

        });

        quitBtn = new JButton("Quit!");
        quitBtn.setFont(new Font("Pacifico", Font.BOLD, 18));
        quitBtn.setBackground(Color.YELLOW);
        quitBtn.setForeground(Color.BLACK);
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        bottomPnl.add(helloBtn);
        bottomPnl.add(quitBtn);

    }
}
