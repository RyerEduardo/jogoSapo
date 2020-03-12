import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sapo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sapo extends Actor
{
    public static final int TAXA_DE_ATUALIZACAO = 15;
    public static final int PULO = 400;
    
    public static final int MAX_PULO = 15;
    
    public boolean terraFirme = true;
    public boolean estaPulando = false;
    private int alturaAtualDoPulo = 0;
    
    private int cicloAtual = 0; //ciclo do act
    public boolean morto = false; //sapo morto
    private int placar = 0; //placar do jogo
    private int vida = 3;
    
   
       
    public void act() 
    {
        
      
        getWorld().showText(("Placar: " + placar),100,30);//exibiçao do placar 
         getWorld().showText(("Vidas: " + vida),990,30);
        
       if((cicloAtual % TAXA_DE_ATUALIZACAO) == 0){ //diminui a velocidade de troca de troca de imagem do sapo
           if(morto != true){
               setImage(new GreenfootImage("normal.png")); //se vivo
               
            }
            else{
                setImage(new GreenfootImage("triste.png"));//se morto
            }
        }
       
       Actor mosca = getOneIntersectingObject(Mosca.class); // pra saber se relou na mosca
       
       if(mosca != null){// pra saber se relou na mosca
           
           setImage(new GreenfootImage("bocaAberta.png"));
           
            Greenfoot.playSound("come.mp3");
           placar++;
           if(placar % 20 == 0){ // se multiplo de 20
             getWorld().addObject(new Doce(), 500, 100);
            }
           
           getWorld().showText(("Placar: " + placar),100,30);//exibiçao do placar 
           getWorld().removeObject(mosca);//tira a mosca do jogo
           
           if(placar % 2 != 0){ //sempre que o total de moscas for impar outras duas seram criadas
             getWorld().addObject(new Mosca(), 100, 0);
             getWorld().addObject(new Mosca(), 1100, 100);
            }
       }
       
       
       Actor abelha = getOneIntersectingObject(Abelha.class);
       
         if(abelha != null){// pra saber se relou na abelha
           setImage(new GreenfootImage("bocaAberta.png"));
           
            Greenfoot.playSound("comeAbelha.mp3");
           getWorld().removeObject(abelha);//remove abelha
           setImage(new GreenfootImage("triste.png"));

           
           vida--;
           getWorld().showText(("Vidas: " + vida),990,30);
          
           getWorld().addObject(new Abelha(), 1100, 100); // sempre que uma abelha morrer nascera outra
            
           
           if(vida == 0){
             
               abelhaPicou();
            }
       }
       
       Actor doce = getOneIntersectingObject(Doce.class); // pra saber se relou no doce
       
        if(doce != null){// se existir doce
           
           setImage(new GreenfootImage("bocaAberta.png"));
           
            Greenfoot.playSound("comeDoce.mp3");
           vida++;
          
           getWorld().removeObject(doce);//tira o doce do jogo
           
           
       }
       
       
       if(Greenfoot.isKeyDown("left")){
           setLocation(getX() - 4, getY());//movimentaçao no eixo x para esquerda
        }
        
       if(Greenfoot.isKeyDown("right")){
           setLocation(getX() + 4, getY());//movimentaçao no eixo x para direita
       }
       
       if(Greenfoot.isKeyDown("space") && terraFirme){
           terraFirme = false;
           estaPulando = true;
       }
       
       subidaPulo();
       apicePulo();
       decidaPulo();
       pousaPulo();
       cicloAtual++; // aumento o ciclo do sapo
    }
   
    
    //retornar o valor do limite inferior do personagem
    public int alturaPes(){
        return getY() + getImage().getHeight()/2;
    }
    
    //retorna a altura atual do personagem dentro do jogo
    public int alturaAtual(){
        return (alturaPes() - Sapolandia.SOLO) * -1; //-1 pra voltar valor positivo
    }
    
    //gravidade da subida do pulo
    public void subidaPulo(){
        if(alturaAtualDoPulo < MAX_PULO && estaPulando){
            alturaAtualDoPulo++;
            setLocation(getX(), getY() - Sapolandia.FORCA_GRAVIDADE * 2);
        }
    }
    
    //gravidade da decida do pulo com mudanca de estatus boolean
    public void apicePulo(){
        if(alturaAtualDoPulo == MAX_PULO && estaPulando){
            alturaAtualDoPulo--;
            estaPulando = false;
        }
    }
    
     //gravidade da decida do pulo com mudanca de estatus boolean
    public void decidaPulo(){
        if(alturaAtualDoPulo > 0 && !estaPulando){
            alturaAtualDoPulo--;
        }
    }
    
     //gravidade da decida do pulo com mudanca de estatus boolean
    public void pousaPulo(){
        if(alturaAtualDoPulo == 0 && !estaPulando){
            terraFirme = true;
        }
    }
    
  
    
    //ao relar na abelha e exibi os resultados
    public void abelhaPicou(){
            
            
           getWorld().addObject(new FimDeJogo(), 525, 275);//tela de game over
            if(placar > 100){
                getWorld().showText(("Fim de jogo!\n\nPARABENS PEQUENO ANFIBIO\n novo recorde: " + placar + "\n\n\nRECORDES:\nEduardo...100\nEdinaldo...99"),525, 250);
            }
            else{
            getWorld().showText(("Fim de Jogo!\n\n\nRECORDES:\nEduardo...100\nEdinaldo...99\n\nVoce...." + placar),525, 250);
         }
         Greenfoot.playSound("gameover.mp3");
        Greenfoot.stop();
        
        
        
    }
    
}
  

