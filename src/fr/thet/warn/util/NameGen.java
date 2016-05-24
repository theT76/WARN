package fr.thet.warn.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NameGen
{
  private static final List<Alphabet> letters = Collections.unmodifiableList(Arrays.asList(Alphabet.values()));
  
  public static String newName()
  {
    Random r = new Random();
    int size = 2;
    
    StringBuilder sb = new StringBuilder();
    while (size > 0)
    {
      size--;
      sb.append(getRandomLetter());
    }
    sb.append(r.nextInt(99));
    
    return ("§7" +sb.toString()) ;
  }
  
  private static String getRandomLetter()
  {
    Random r = new Random();
    return ((Alphabet)letters.get(r.nextInt(letters.size()))).name();
  }
  
  private static enum Alphabet
  {
    a,  b,  c,  d,  e,  f,  g,  h,  i,  j,  k,  l,  m,  n,  o,  p,  q,  r,  s,  t,  u,  v,  w,  x,  y,  z;
  }
}
