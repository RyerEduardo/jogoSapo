import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Doce here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Doce extends Actor
{
    /**
     * Act - do whatever the Doce wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(4);
        if(Greenfoot.getRandomNumber(90)<6){
            turn(Greenfoot.getRandomNumber(20)-30);
        }// Add your action code here.
    }    
}
