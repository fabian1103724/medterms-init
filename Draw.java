import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Draw extends JComponent{

	public BufferedImage image;
	public BufferedImage backgroundImage;
	public int x = 30;
	public int y = 30;


	Monster monster1;
	Monster monster2;
	Hero hero1;

	public Draw(){
		monster1 = new Monster(200, 200);
		monster2 = new Monster(300, 200);
		hero1 = new Hero(300, 200);

		try{

			backgroundImage = ImageIO.read(getClass().getResource("background.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.drawImage(backgroundImage, 0, 0, this);
		g.drawImage(image, x, y, this);

		g.drawImage(monster1.image, monster1.xPos, monster1.yPos, this);
		g.drawImage(monster2.image, monster2.xPos, monster2.yPos, this);
	}
	
	
}