package net.BukkitPE.debug;
public class debug{
  function debug(string astring){
	  string aastring = "]0;" + astring;
    System.out.print((char) 0x1b + aastring + (char) 0x07);
  }
  //call net.BukkitPE.debug("Text to output to console, to use; it will reduce the jar file size.");
}
