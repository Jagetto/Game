# Sprite

Diese Klasse vereinfacht das Umgehen mit Bildern. Java stellt unter anderem die Klasse [BufferedImage](https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html) bereit, um mit Bildern zu arbeiten. Diese hat jedoch den Nachteil, das einfache Dinge wie das Drehen extrem kompliziert werden können. Dies wird mit dieser Klasse vereinfacht.

Es wird später weitere Varianten von Sprites geben wie z.B. `AnimatedSprite` zum Anzeigen von Bildfolgen.

## Ein neues Sprite erstellen

Es gibt zwei Möglichkeiten Sprites zu erstellen. Ein Konstruktor erwartet lediglich das anzuzeigende `BufferedImage` und gibt nicht die Möglichkeit direkt Einstellungen zu treffen.

```java
Sprite newSprite = new Sprite(someKindOfBufferedImage);
```

Der andere Konstruktor nimmt einige weitere Parameter zusätzlich an. Dabei handelt es sich um die Transparenz, die Drehung und die horizontale Spiegelung.

```java
//erstellt ein neues Sprite mit someKindOfBufferedImage als Bild, einer Transparenz von 0.8f, einer Drehung von 0.7f, welches horizontal gespiegelt ist
Sprite newSprite = new Sprite(someKindOfBufferedImage, 0.8f, 0.7f, true);
```

## Ein Sprite rendern

Hierfür gibt es die Methode `render(Graphics g, float x, float y, float width, float height)`. Der erste Parameter erwartet ein [Graphics](https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html)-Objekt, während die restlichen vier Werte die Position und Größe des zu zeichnenden Bilds in Pixeln sind.

## Werte

Die Werte `image`, `transparency`, `rotation` und `flip` können mit Gettern / Settern beeinflusst werden.