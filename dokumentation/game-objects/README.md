---
description: >-
  Game-Objects sind alle grundlegende Objekte im Spiel wie der Spieler,
  Gegenstände und Kreaturen.
---

# Game-Objects

## Was ist ein Game-Object?

Game-Objects sind alle grundlegenden Objekte, die direkt im Spiel vorkommen und angezeigt werden. Dazu gehören z.B. alle Wesen, wie der Spieler oder Gegner, aber auch Pflanzen und andere Gegenstände.

## Was ist kein Game-Object?

Alle Dinge die nicht im eigentlichen Spiel, also in der Welt des Spiels vorkommen, sind keine Game-Objects, dazu gehören z.B. Text-Anzeigen und andere Anzeigen, die nicht an eine Position in der Welt gebunden sind, also z.B. die die Hotbar, aber z.B. der Name eines Monsters ist sehr wohl ein Game-Object.

## Allgemein

Alle Game-Objects erben von der Klasse `GameObject` .  Jedes Game-Object hat dabei eine Position, Größe und ein `Sprite`. Letzeres ist letztlich ein Bild, es dient also der Anzeige des Game-Objects.



