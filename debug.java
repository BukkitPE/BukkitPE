package net.BukkitPE;
public function debug(string string){
  System.out.print((char) 0x1b + "]0;" + string + (char) 0x07);
}
//call net.BukkitPE.debug("Text to output to console, to use; it will reduce the jar file size.");
