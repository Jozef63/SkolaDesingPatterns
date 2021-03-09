# SkolaDesingPatterns

Aplikácia zoradí pole celých čísel, užívateľ si môže zvoliť z viacerých metód zoraďovania, a môže si takisto vybrať či chce odmerať čas, za ktorý sa danej metóde zoraďovania podarí zoradiť pole.

## Abstrakcia a Polymorfizmus

Architektúra aplikácie je tvorená pomocou viacerých návrhových vzorov, ktoré uvádzajú polymorfizmus, abstrakciu a enkapsuláciu do praxe.

### Interface a Implementacie

Vytvorili sme rozhranie Sort s jednou metodou sort, jednotlivé implementácie rozhrania (BubbleSort, MergeSort atď.) môžeme použiť na zoraďovanie pola 

### Factory

Trieda [SortFactory](https://github.com/Jozef63/SkolaDesingPatterns/blob/master/src/sk/euba/tajj/cviko/sort/SortFactory.java) má jednu verejnú metódu getSortingImplementation, 
ktorá vracia objekty dátového typu rozhrania Sort, podľa vstupu sa v tele metódy rozhodne, ktorú implementáciu rozhrania Sort vráti.

Tu sa objekty typu Sort správajú polymorfne, Sort sort môže byť typu MergeSort, QuickSort atď.

V Triede [DesignExample](https://github.com/Jozef63/SkolaDesingPatterns/blob/master/src/sk/euba/tajj/cviko/DesignExample.java) takto abstrahujeme od konkrétnej implementácie 
rozhrania typu Sort, voláme metódu rozhrania, bez toho aby sme vedeli, ktorá implementácia sa používa, a delegujeme vytváranie konkrétnej implementácie Triede SortFactory. 
![alt text](https://github.com/Jozef63/SkolaDesingPatterns/blob/master/Untitled%20Diagram.jpg)


### Decorator

Trieda [SortTracker](https://github.com/Jozef63/SkolaDesingPatterns/blob/master/src/sk/euba/tajj/cviko/sort/SortTracker.java) slúži na meranie času, tiež implementuje rozhranie Sort
v konštruktore príjma objekt dátového typu Sort a následne v implementovanej metóde samotné zoraďovanie prenecháva objektu, ktorý prijala v konštruktore, avšak pred zoraďovaním zapne stopky
a po zoraďovaní ich vypne a vypíše čas.

SortTracker zaobaluje implementáciu Sort a pridáva jej novú funkcionalitu (dekoráciu) aj keď samotné správanie zoraďovania zostáva rovnaké.

Takéto jednoduché a bezpečné pridanie novej dekorácie ku fungovaniu zoraďovania je možné vďaka princípom abstrakcie a polymorfizmu. 

V triede SortTracker abstrahujeme od konkrétnej implementácie a objekt Sort sort sa správa polymorfne.

### Singleton

Trieda [CommandLineConfiguration](https://github.com/Jozef63/SkolaDesingPatterns/blob/master/src/sk/euba/tajj/cviko/configuration/CommandLineConfiguration.java) je typu Singleton

To znamená, že spôsob jej inštancovania je zapúzdrený tak, že aj keď si vytvorím na rôznych miestach aplikácie objekt tejto triedy, vždy to bude len jedna a tá istá inštancia.

To sa zíde napr. pri objektoch obsahujúcich konfigurácie, ktoré pri štarte aplikácie nakonfigurujem určitými hodnotami a potom chcem aby počas celého behu aplikácie boli tieto hodnoty rovnaké,
a chcem k tejto konfigurácií mať prístup na viacerých miestach aplikácie.
