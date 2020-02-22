# Assets

Diese Datei ist zum Laden der Bilder aus dem Speicher mithilfe des [FileLoaders](FileLoader.md) gedacht.

## Ein Bild hinzufügen

### 1. Die Variable deklarieren

Zunächst muss die Variable deklariert werden. Hierfür wird einfach, mit einem Komma abgetrennt, der Name für das Bild an die oberste Zeile in der Klasse angehängt. Dieser sollte komplett aus Großbuchstaben bestehen. Verschiedene Wörter sollten mit einem Unterstrich abgetrennt werden.

```java
//Beispiel
public static BufferedImage DEBUG, TEST, PLAYER, IRON_SWORD, MY_NEW_IMAGE;
```

### 2. Das Bild aus dem Speicher laden

Dafür muss dem Bild in der Methode `init()` nur noch das aus dem Speicher geladene Bild hinzugefügt werden. Dies geschieht mithilfe des [FileLoaders](FileLoader.md):

```java
MY_NEW_IMAGE = FileLoader.loadImage("myImagePath");
```