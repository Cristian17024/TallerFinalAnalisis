# RPG por turnos (Strategy + Factory Method + Decorator)

Compilar y ejecutar (Java 11+):
    cd src && mkdir -p ../out && javac -encoding UTF-8 -d ../out *.java
    cd ../out && java -Dfile.encoding=UTF-8 Main          # modo interactivo
    java -Dfile.encoding=UTF-8 Main demo                  # 4 corridas de ejemplo

- Strategy: EstrategiaAtaque -> AtaqueEspada, AtaqueHechizo, AtaqueFlecha, AtaquePunalada
- Factory Method: CreadorPersonaje (Guerrero, Mago, Arquero, Pícaro), CreadorEnemigo (Goblin, Orco, Dragón)
- Decorator: Espada, Armadura, Veneno (modifica atacar + DOT), AmuletoRegeneracion (regenera HP), Bendicion (+15%)
- Extra: Bitácora con estadísticas finales y marca de victoria; iniciativa por velocidad.
