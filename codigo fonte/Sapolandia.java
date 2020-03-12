import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sapolandia extends World
{
    public static final int LARGURA_C = 1050;
    public static final int ALTURA_C = 550;
    public static final int FORCA_GRAVIDADE = 4;
    public static final int SOLO = 540;
    private int quadroAtual = 1;
    
    Sapo sapo = new Sapo();
  
    
   
    public Sapolandia()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(LARGURA_C, ALTURA_C, 1);
        setBackground("background1.png"); // colocar cenario do jogo
        Greenfoot.playSound("som.mp3");
        addObject(sapo, 250, 470); // local onde o sapo nasce
        
        addObject(new Mosca(), 1100, 100);
        addObject(new Mosca(), 100, 50);//local onde a comida fica
        addObject(new Abelha(), 120, 52);
        addObject(new Mosca(), 300, 100);// x e y
        addObject(new Abelha(), 500, 50);
        addObject(new Mosca(), 700, 100);
        addObject(new Abelha(), 900, 50);
        
        
    }
    
    
    //gravidade da decida do pulo do sapo
    public void forcaGravidade(){
        if(sapo.alturaAtual() > 0){
            sapo.setLocation(sapo.getX(), sapo.getY() + FORCA_GRAVIDADE);
        }
    }
    
    public void act(){
        setBackground("background"+quadroAtual+".png"); // "cenario" do jogo rodando
        
        forcaGravidade();
    }
}
