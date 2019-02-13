import java.io.IOException;
import javax.swing.JComponent;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Hero{
	public Draw comp;
	public int xPos = 300;
	public int yPos = 300;
	public BufferedImage image;
	public int x = 30;
	public int y = 30;
	public int state = 0;
	public URL resource = getClass().getResource("run0.png");

	public Hero(Draw comp){
		this.comp = comp;
	
	}
	

	public void reloadImage(){
		state++;

		if(state == 0){
			resource = getClass().getResource("run0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("run1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("run2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("run3.png");
		}
		else if(state == 4){
			resource = getClass().getResource("run4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("run5.png");
			state = 0;
		}

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void attackAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("attack"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        comp.repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}


				for(int x=0; x<comp.monsters.length; x++){
					if(comp.monsters[x]!=null){
						if(comp.monsters[x].contact){
							comp.monsters[x].life = comp.monsters[x].life - 10;
						}
					}
				}
			}
		});
		thread1.start();
	}

	public void moveUp(){
		y = y - 5;
		
		reloadImage();
		comp.repaint();
		comp.checkCollision();
		
	}

	public void moveDown(){
		y = y + 5;
		
		
		reloadImage();
		comp.repaint();
		comp.checkCollision();
		
	}

	public void moveLeft(){
		x = x - 5;
		
		comp.repaint();
		comp.checkCollision();
	}

	public void moveRight(){
		x = x + 5;
		reloadImage();
		comp.repaint();
		comp.checkCollision();
	}

	public void attack(){
		attackAnimation();
	
	}


}