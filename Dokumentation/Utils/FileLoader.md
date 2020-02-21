# FileLoader

Diese Klasse ist zum Laden von verschiedenen Files gedacht. Zum jetzigen Zeitpunkt enthält sie lediglich eine Methode.

## `loadImage(String path)`

Diese Methode lädt das Bild an dem angebenen Pfad relativ zu `Game/assets/img` und gibt ein [BufferedImage](https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html) zurück. Soll also z.B. das Bild `player.png` geladen werden, das sich direkt im Ordner `img` befindet, muss Folgendes eingegeben werden:

```java
FileLoader.loadImage("player.png");
```

Wenn das Bild nicht gefunden wurde throwt die Methode eine `FileNotFoundException`.

