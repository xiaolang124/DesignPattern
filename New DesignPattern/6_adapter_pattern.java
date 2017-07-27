//���� 1
//Ϊý�岥�����͸��߼���ý�岥���������ӿڡ�
//	MediaPlayer.java
public interface MediaPlayer {
   public void play(String audioType, String fileName);
}
//	AdvancedMediaPlayer.java
public interface AdvancedMediaPlayer {	
   public void playVlc(String fileName);
   public void playMp4(String fileName);
}
//���� 2
//����ʵ���� AdvancedMediaPlayer �ӿڵ�ʵ���ࡣ
//	VlcPlayer.java
public class VlcPlayer implements AdvancedMediaPlayer{
   @Override
   public void playVlc(String fileName) {
      System.out.println("Playing vlc file. Name: "+ fileName);		
   }

   @Override
   public void playMp4(String fileName) {
      //ʲôҲ����
   }
}
//	Mp4Player.java
public class Mp4Player implements AdvancedMediaPlayer{

   @Override
   public void playVlc(String fileName) {
      //ʲôҲ����
   }

   @Override
   public void playMp4(String fileName) {
      System.out.println("Playing mp4 file. Name: "+ fileName);		
   }
}
//���� 3
//����ʵ���� MediaPlayer �ӿڵ��������ࡣ
//	MediaAdapter.java
public class MediaAdapter implements MediaPlayer {

   AdvancedMediaPlayer advancedMusicPlayer;

   public MediaAdapter(String audioType){
      if(audioType.equalsIgnoreCase("vlc") ){
         advancedMusicPlayer = new VlcPlayer();			
      } else if (audioType.equalsIgnoreCase("mp4")){
         advancedMusicPlayer = new Mp4Player();
      }	
   }

   @Override
   public void play(String audioType, String fileName) {
      if(audioType.equalsIgnoreCase("vlc")){
         advancedMusicPlayer.playVlc(fileName);
      }else if(audioType.equalsIgnoreCase("mp4")){
         advancedMusicPlayer.playMp4(fileName);
      }
   }
}
//���� 4
//����ʵ���� MediaPlayer �ӿڵ�ʵ���ࡣ
//	AudioPlayer.java
public class AudioPlayer implements MediaPlayer {
   MediaAdapter mediaAdapter; 

   @Override
   public void play(String audioType, String fileName) {		

      //���� mp3 �����ļ�������֧��
      if(audioType.equalsIgnoreCase("mp3")){
         System.out.println("Playing mp3 file. Name: "+ fileName);			
      } 
      //mediaAdapter �ṩ�˲��������ļ���ʽ��֧��
      else if(audioType.equalsIgnoreCase("vlc") 
         || audioType.equalsIgnoreCase("mp4")){
         mediaAdapter = new MediaAdapter(audioType);
         mediaAdapter.play(audioType, fileName);
      }
      else{
         System.out.println("Invalid media. "+
            audioType + " format not supported");
      }
   }   
}
//���� 5
//ʹ�� AudioPlayer �����Ų�ͬ���͵���Ƶ��ʽ��
//	AdapterPatternDemo.java
public class AdapterPatternDemo {
   public static void main(String[] args) {
      AudioPlayer audioPlayer = new AudioPlayer();

      audioPlayer.play("mp3", "beyond the horizon.mp3");
      audioPlayer.play("mp4", "alone.mp4");
      audioPlayer.play("vlc", "far far away.vlc");
      audioPlayer.play("avi", "mind me.avi");
   }
}
//���� 6
//��֤�����
Playing mp3 file. Name: beyond the horizon.mp3
Playing mp4 file. Name: alone.mp4
Playing vlc file. Name: far far away.vlc
Invalid media. avi format not supported