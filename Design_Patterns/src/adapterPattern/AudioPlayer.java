package adapterPattern;
/*
 * We want to make AudioPlayer to play other formats as well. To attain this, we have created an adapter class MediaAdapter which implements the
 *  MediaPlayer interface and uses AdvancedMediaPlayer objects to play the required format.
 */
public class AudioPlayer implements MediaPlayer {

	 MediaAdapter mediaAdapter; 
	
	 @Override
	   public void play(String audioType, String fileName) {		

	      //inbuilt support to play mp3 music files
	      if(audioType.equalsIgnoreCase("mp3")){
	         System.out.println("Playing mp3 file. Name: " + fileName);			
	      } 
	      
	      //mediaAdapter is providing support to play other file formats
	      else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
	         mediaAdapter = new MediaAdapter(audioType);
	         mediaAdapter.play(audioType, fileName);
	      }
	      
	      else{
	         System.out.println("Invalid media. " + audioType + " format not supported");
	      }
	 }
}
