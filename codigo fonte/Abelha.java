import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Abelha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Abelha extends Actor
{
    /*
     * Act - do whatever the Doce wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       //cair();
       move(4);
        if(Greenfoot.getRandomNumber(80)<5){
            turn(Greenfoot.getRandomNumber(15)-30);
        }
        
        
    }  

    
}
