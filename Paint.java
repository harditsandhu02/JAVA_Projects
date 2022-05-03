package Challenge;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
/**
 * This program is a class where anyone can draw or paint whatever. 
 * With many options like erase, random, and custom colors,
 * the possibilities are endless!
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 12 -- Challenge
 *
 * @author Hardit Sandhu
 * @version April 12, 2022
 */
public class Paint extends JComponent implements Runnable {
    private Image image; // the canvas
    private Graphics2D graphics2D;  // this will enable drawing
    private int curX; // current mouse x coordinate
    private int curY; // current mouse y coordinate
    private int oldX; // previous mouse x coordinate
    private int oldY; // previous mouse y coordinate

    private static JTextField hexText;
    private static JTextField rText;
    private static JTextField gText;
    private static JTextField bText;

    JButton clrButton;
    JButton fillButton;
    JButton eraseButton;
    JButton randomButton;

    JButton hexButton;
    JButton rgbButton;

    Paint paint; // variable of the type ColorPicker

    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            /* this lets us draw on the image (ie. the canvas)*/
            graphics2D = (Graphics2D) image.getGraphics();
            /* gives us better rendering quality for the drawing lines */
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            /* set canvas to white with default paint color */
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            graphics2D.setBackground(Color.white);
            draw(5);
            hexText.setText("#");
            rText.setText("");
            gText.setText("");
            bText.setText("");
            repaint();
        }
        g.drawImage(image, 0, 0, null);
    }

    /* action listener for buttons */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clrButton) {
                paint.clear();
            }
            if (e.getSource() == fillButton) {
                paint.fill();
            }
            if (e.getSource() == eraseButton) {
                paint.erase();
            }
            if (e.getSource() == randomButton) {
                paint.randomize();
            } 
        }
    };

    /* set up paint colors */
    public void clear() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();

        hexText.setText("#");
        rText.setText("");
        gText.setText("");
        bText.setText("");
    }

    public void fill() { // have to click the screen again to fill
        graphics2D.setBackground(graphics2D.getColor());
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        repaint();

        hexText.setText("#");
        rText.setText("");
        gText.setText("");
        bText.setText("");
    }

    public void erase() {
        graphics2D.setPaint(graphics2D.getBackground());
    }
    
    public void randomize() {
        Random random = new Random();
        int hex = 0;
        do {
            hex = random.nextInt();
        } while (hex > 999999 || hex < 100000);

        String hexNum = "#" + String.valueOf(hex);
        hexText.setText(hexNum);
        graphics2D.setPaint(Color.decode(hexNum));

        String green = String.valueOf(graphics2D.getColor().getGreen());
        gText.setText(green);

        String red = String.valueOf(graphics2D.getColor().getRed());
        rText.setText(red);

        String blue = String.valueOf(graphics2D.getColor().getBlue());
        bText.setText(blue);
    }

    public Paint() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                /* set oldX and oldY coordinates to beginning mouse press*/
                oldX = e.getX();
                oldY = e.getY();
            }
        });


        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                /* set current coordinates to where mouse is being dragged*/
                curX = e.getX();
                curY = e.getY();

                /* draw the line between old coordinates and new ones */
                graphics2D.drawLine(oldX, oldY, curX, curY);

                /* refresh frame and reset old coordinates */
                repaint();
                oldX = curX;
                oldY = curY;
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Paint());
    }

    @Override
    public void run() {
        /* set up JFrame */
        JFrame frame = new JFrame("Homework 12 Artwork");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        paint = new Paint();
        content.add(paint, BorderLayout.CENTER);

        // -----------------------------------------------
        clrButton = new JButton("Clear");
        clrButton.addActionListener(actionListener);
        fillButton = new JButton("Fill");
        fillButton.addActionListener(actionListener);
        eraseButton = new JButton("Erase");
        eraseButton.addActionListener(actionListener);
        randomButton = new JButton("Random");
        randomButton.addActionListener(actionListener);
        hexButton = new JButton("#");
        rgbButton = new JButton("RGB");
        rgbButton.addActionListener(actionListener);
        // -----------------------------------------------


        // -----------------------------------------------
        JPanel panel = new JPanel();
        panel.add(clrButton);
        panel.add(fillButton);
        panel.add(eraseButton);
        panel.add(randomButton);
        content.add(panel, BorderLayout.NORTH);
        // -----------------------------------------------

        // -----------------------------------------------
        JPanel bottomPan = new JPanel();
        bottomPan.add(hexButton);
        hexText = new JTextField(10);
        bottomPan.add(hexText);
        bottomPan.add(rgbButton);
        rText = new JTextField(5);
        bottomPan.add(rText);
        gText = new JTextField(5);
        bottomPan.add(gText);
        bText = new JTextField(5);
        bottomPan.add(bText);
        content.add(bottomPan, BorderLayout.SOUTH);
        // -----------------------------------------------

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        // if the # button is clicked
        hexButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Color newCOl;
                    if (hexText.getText().contains("#")) {
                        newCOl = Color.decode(hexText.getText());
                    } else {
                        newCOl = Color.decode("#" + hexText.getText());
                    }
                    paint.newCol(newCOl);

                    String red = String.valueOf(newCOl.getRed());
                    rText.setText(red);
                    String green = String.valueOf(newCOl.getGreen());
                    gText.setText(green);
                    String blue = String.valueOf(newCOl.getBlue());
                    bText.setText(blue);

                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "Not a valid Hex Value", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, "Not a valid Hex Value", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // if the RGB button is 'clicked'
        rgbButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                
                    if (rText.getText().equals("")) {
                        rText.setText("0");
                    }
                    if (gText.getText().equals("")) {
                        gText.setText("0");
                    }
                    if (bText.getText().equals("")) {
                        bText.setText("0");
                    }

                    int r = Integer.parseInt(rText.getText());
                    int g = Integer.parseInt(gText.getText());
                    int b = Integer.parseInt(bText.getText());

                    Color newCol = new Color(r, g, b);
                    paint.newCol(newCol);


                    String hex = String.format("#%02x%02x%02x", r, g, b);
                    hexText.setText(hex);

                    String red = String.valueOf(r);
                    rText.setText(red);
                    String green = String.valueOf(g);
                    gText.setText(green);
                    String blue = String.valueOf(b);
                    bText.setText(blue);

                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "Not a valid RGB Value", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, "Not a valid RGB Value", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public void draw(int size) {
        graphics2D.setStroke(new BasicStroke(size));
    }    
    public void newCol(Color col) {
        graphics2D.setColor(col);
    }
}