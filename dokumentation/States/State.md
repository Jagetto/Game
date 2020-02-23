# State

States sind Zustände des Programms. Es kann hierbei immer nur einen aktiven State geben. Dieser wird in `Game` gespeichert. Beispiele für solche States, die es später einmal geben wird oder bereits implementiert sind, sind z.B. `GameState` , der für die Verwaltung des eigentlichen Spiels zuständig ist, `MenuState`, der das Menu des Spiels verwaltet, `LoadingState`, für einen Lade-Screen beim Starten des Spiels.

## Einen State festlegen / den momentanen State erhalten

Der State wird in `Game` gespeichert und kann über Getter bzw. Setter beeinflusst werden. Wenn ein neuer State erzeugt wird muss normalerweise in Parametern das `Game` - Objekt angegeben werden:

```java
//get the current state
game.getState();

//set the state to a new one
State myNewState = new GameState(game);
State myNewState = new MenuState(game);
State myNewState = new LoadingState(game);
...

game.setState(myNewState);
```

## Eigene State-Klasse

Da State `abstract` ist, kann kein State-Objekt erzeugt werden. Deshalb muss für den State eine von State erbenden Klasse geschrieben werden.

```java
new State(game); //Error: Cannot initialize type State
new GameState(game); //Works
```

Wenn eine von State erbende Klasse in erstellt wird, wird man dazu gezwungen einen Konstruktor zu implementieren, der den State-Konstruktor, also mithilfe von `super()`, aufruft und ein `Game` -Objekt angibt. Es macht Sinn dieses Objekt selbst als Parameter anzufordern und dann einfach weiterzureichen:

```java
public class MySuperCoolState extends State {

    public MySuperCoolState(Game game) {
        super(game);
        //do your constructor stuff here
    }
    
    //more to come
    
}
```

Weiterhin ist es nötig 5 weitere Methoden zu implementieren, um den Syntax-Fehlern zu entgehen. Diese lauten `load()`, `tick(double deltaTime)`, `render(Graphics g)`, `resize(int width, int height)`und `dispose()`.

### `load()`

Diese Methode wird aufgerufen, wenn der State gestartet wird.

### `tick(double deltaTime)`

Diese Methode wird jeden Tick aufgerufen, was im Schnitt bis zu 60 mal pro Sekunde geschehen kann. `deltaTime` ist die Zeit in Sekunden seit dem letzten Aufruf.

### `render(Graphics g)`

Diese Methode wird nach jedem Tick aufgerufen, was im Schnitt bis zu 60 mal pro Sekunde geschehen kann. `g` ist das [Graphics](https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html)-Objekt, was zum Zeichnen benutzt werden kann.

### `resize(int width, int height)`

Diese Methode wird aufgerufen, wenn sich die Fenstergröße verändert. Die Parameter sind die neuen Abmessungen in Pixeln.

### `dispose()`

Diese letzte Methode wird aufgerufen, bevor der State beendet wird.

