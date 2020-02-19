# GameObject

Diese Klasse ist die Super-Klasse aller Game-Objects.

## Game-Objects

Diese Game-Objects beschreiben dabei alle Objekte, die im eigentlichen Spiel vorhanden sind. Dazu gehören zum Beispiel der Spieler, Gegner und NPCs aber auch Pflanzen, Gegenstände und Wände.

Anzeigen, die nicht Teil der Welt sind, also z.B. die Hotbar oder Lebensanzeige sind hingegen *keine Game-Objects*. Dies ist nicht zu verwechseln mit Text, der in der Welt angezeigt wird und in dieser eine spezifische Position hat, also z.B. der Text, der über einem Charakter angezeigt wird.

## Ein neues GameObject hinzufügen

Im Folgenden wird erläutert, wie ein neues GameObject initialisiert wird und anschließend der Welt hinzugefügt wird. Zunächst muss ein neues Objekt der Klasse `GameObject` initialisiert werden. Es müssen hierbei eine ganze Menge an Parametern angegeben werden.

Zunächst wird die `GameState` erwartet. In den meisten Fällen werden Game-Objects in einer Methode der Klasse `GameState` erstellt, sodass in diesem Fall mit `this` ein Verweis auf ebendiese `GameState` erzeugt werden kann (siehe den untenstehenden Konstruktor). Wenn Game-Objects in einer von `GameObject` erbenden Klasse erstellt werden, ist die Variable `state` verfügbar und kann einfach weitergegeben werden (siehe ebenfalls unter).

Es folgt ein [Sprite](../utils/sprite.md), also die visuelle Repräsentation des Game-Objects. In den Beispielen wurde ein einfaches Sprite erstellt und als Parameter das in `Assets` gespeicherte Bild `PLAYER` übergeben.

Die letzten vier Parameter sind allesamt Zahlen. Dabei beschreiben die ersten beiden Parameter die Position und die letzten beiden die Größe des Game-Objects. Es gilt zu beachten, dass die angegeben Werte in den Einheiten des Spiels übergeben werden. Dies bedeutet, dass es sich nicht um Pixel-Werte handelt. Der Umrechnungsfaktor ist unter `Global.SCALE` gespeichert und beträgt `64`. Eine Spiel-Einheit, also, wenn man so möchte, ein Meter im Spiel entspricht demnach 64 Pixeln.

```java
//in der Klasse GameState
GameObject myNewGameObject = new GameObject(this, new Sprite(Assets.PLAYER), 42, 42, 1, 1)
//in einer von GameObject erbenden Klasse (z.B. Player)
GameObject myNewGameObject = new GameObject(state, new Sprite(Assets.PLAYER), 42, 42, 1, 1)
```

Nachdem dies geschehen ist muss es noch dem `GameObjectManager` hinzugefügt werden. Dies geschieht mit der Methode `add(GameObject gameObject)`. Um den `GameObjectManager` zu erhalten, kann die Methode `getGameObjectManager()` der Klasse `GameState` verwendet werden:

```java
//in der Klasse GameState
getGameObjectManager().add(myNewGameObject);
//oder direkt:
gameObjectManager.add(myNewGameObject);
//in einer von GameObject erbenden Klasse (z.B. Player)
state.getGameObjectManager().add(myNewGameObject);
```

