
# Rapport
Skiss/design-idé
Bild på skiss av layout:
![](Layout%20app-MyTopDesserts.png)


Webbtjänst - JSON
I Github-projektets README.md skall ni inkludera en beskrivning av de JSON-objekt som er app presenterar under rubriken Webbtjänst - JSON
Inkludera en kodsnutt (prettyfied JSON) som innehåller ett exempel-objekt. Kom ihåg att använda Markdown code-block.
Beskriv kortfattat vad JSON-objektets olika attribut innehåller för information. Det räcker med 1-2 meningar per attribut.
(Attributen ID och Login behöver inte beskrivas/förklaras)

Implementationsexempel
I Github-projektets README.md skall ni inkludera 2-3 implementationsdetaljer under rubriken
Implementationsexempel Ni väljer själva vilka implementationsdetaljer som ni vill beskriva.
Om ni har frångått er ideskiss så kan det vara lämpligt att ha med någon kommentar kring varför detta skedde.
En implementationsdetalj skall inkludera:
● Minst en kodsnutt (glöm inte att använda Markdown code-block) ○ Om ni 
t ex beskriver något som relaterar till både Java-kod och XML-kod så är det vettigt att 
ha två separata kodsnuttar ○ Varje kodsnutt skall ha ett unikt nummer, t ex figur 1, figur 2, osv ● 
En kort beskrivning som beskriver vad kodsnutt/kodsnuttarna åstakommer ● Minst en screenshot som relaterar t<
ill kodsnutt/kodsnuttarna ● Minst en länk till en relevant commit för kodsnuttarna, t ex när de skapades eller 
när en viktig buggfix gjordes ● Kom ihåg att referera till kodsnutt/kodsnuttar och screenshot(s) i den korta beskrivningen av
implementationsdetaljen

Implementationsexempel VG (för de som satsar på VG) 

Reflektion
I Github-projektets README.md skall ni inkludera kortfattad reflektion kring projekt-uppgiften under rubriken Reflektion. Ni kan till exempel reflektera över om projektuppgiften var för svår/lätt. Om projektuppgiften
täckte in det ni lärt er under kursen. Om ni saknade något? Om något kändes överflödigt?
Reflektionen behöver inte vara mer än 3-4 meningar och skall inte vara längre än 15-20 meningar.

Koden är för att kunna klicka på ett item i recyclerviewn som sedan härleder en till
en ny activity där receptet visas i en webview. 
Figur 1 - MainActivity:
```
adapter = new RecyclerViewAdapter(this, recipes, new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Recipe recipe) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("Recipe url", recipe.getAuxdata().getWiki());
                startActivity(intent);
                Toast.makeText(MainActivity.this, recipe.getName(), Toast.LENGTH_SHORT).show();
            }
        });
```
Koden för recyclerviewadapter för att kunna visa texten av items in i recyclerview eftersom det är adaptern 
som uppdaterar och visar innehållet i recyclerviewn. Länk till commit för koden:
https://github.com/a23yutta/mobileapp-programming-project/blob/3812681e86c24554b1a7b6bd4a3ee6a064fcfc9f/app/src/main/java/com/example/project/MainActivity.java

Figur 2 - RecyclerViewAdapter:
```
public void bind(final Recipe recipe, final OnItemClickListener listener) {
            title.setText(recipe.toString());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(recipe);
                }
            });
        }
```
Screenshot på WebViewActivity recept som visas i en webview i en ny aktivitet när man klickar på en item i recyclerview:
![](Layout%20app-MyTopDesserts.png)
Screenshot på MainActivity där den visar innehållet i recyclerview, listar vardera items namn:
![](Layout%20app-MyTopDesserts.png)


