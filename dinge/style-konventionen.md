---
description: 'Style-Konventionen, damit der Code konsistent ist.'
---

# Style-Konventionen

## Benennung

Alle Bezeichner sollten Englisch sein und aussagefähig. Gerade Abkürzungen oder Bezeichner die nur aus wenigen Buchstaben bestehen sollten vermieden werden. Ausnahmen sind hierfür `x` und `y` sowie Schleifen-Variablen, also z.B.:

```java
for(int i = 0; i < 100; i++) {
    //do something here
}
```

### **Klassen, Enums und Interfaces**

Klassen-Bezeichner sollten immer groß beginnen und für die restlichen Wörter Camel-Case verwenden. Gute Beispiele wären z.B. `GameObject`, `Sprite` oder `GameObjectManager`, während `Gameobject`, `sprite`oder `SpielObjektVerwaltung`schlechte Namen wären. Bezeichner für Interfaces sollten nach Möglichkeit auf `able` enden, also z.B. `Shootable` oder `Collectable`. Ansonsten folgen sie wie auch Enums den gleichen Regeln wie Klassen-Bezeichnern.

### **Variablen und Methoden**

Variablen- und Methoden-Bezeichner sollten immer klein beginnen und für die restlichen Wörter Camel-Case verwenden. Dies gilt auch für die Bezeichner von Variablen von Klassen. `speed`, `position`oder `copperSword` sind gute Bezeichner, während `Speed` , `weltgenerieren` sich weniger eignen. Methoden sollten ein Verb enthalten, das immer Anfang stehen muss. `drawPlayer` ist also besser, als `playerDraw`, auch wenn letztere Möglichkeit der deutschen Grammatik näher kommt.

## Formatierung

### **Klammern**

Die Klammern sollten wie folgt gesetzt werden.

```java
//Gut
if(true) {

}
//Schlecht
if(true)
{

}
```

