import dresseur.Entraineur
import monstre.EspeceMonstre

fun changeCouleur(message: String, couleur:String=""): String {
    val reset = "\u001B[0m"
    val codeCouleur = when (couleur.lowercase()) {
        "rouge" -> "\u001B[31m"
        "vert" -> "\u001B[32m"
        "jaune" -> "\u001B[33m"
        "bleu" -> "\u001B[34m"
        "magenta" -> "\u001B[35m"
        "cyan" -> "\u001B[36m"
        "blanc" -> "\u001B[37m"
        else -> "" // pas de couleur si non reconnu
    }
    return "$codeCouleur$message$reset"
}

var joueur = Entraineur(1, "Sacha", 100)
var rival = Entraineur(2,"Regis",200)
var especeSpringleaf = EspeceMonstre(
    1,
    "Springleaf",
    "Graine",
    9,
    11,
    10,
    12,
    14,
    60,
    6.5,
    9.0,
    8.0,
    7.0,
    10.0,
    34.0,
    "Petit monstre espiègle rond comme une graine, adore le soleil.",
    "Sa feuille sur la tête indique son humeur.\n",
    "Curieux, amical, timide\n")
var especeFlamkip = EspeceMonstre(
    4,
    "Flamkip",
    "Animal",
    12,
    8,
    13,
    16,
    7,
    50,
    10.0,
    5.5,
    9.5,
    9.5,
    6.5,
    22.0,
    "Petit animal entouré de flammes, détecte le froid.",
    "Sa flamme change d’intensité selon son énergie.\n",
    "Impulsif, joueur, loyal\n"
)
var especeAquamy = EspeceMonstre(
    7,
    "Aquamy",
    "Meteo",
    10,
    11,
    9,
    14,
    14,
    55,
    9.0,
    10.0,
    7.5,
    12.0,
    12.0,
    27.0,
    "Créature vaporeuse, semblable à un nuage, produit des gouttes pures.",
    "Fait baisser la température en s’endormant.\n",
    "Calme, rêveur, mystérieux\n"
);

var especeLaoumi = EspeceMonstre(
    8,
    "Laoumi",
    "Animal",
    11,
    10,
    9,
    8,
    11,
    58,
    11.0,
    8.0,
    7.0,
    6.0,
    11.5,
    23.0,
    "Petit ourson au pelage soyeux, aime se tenir debout.",
    "Est mignon mais il protège ses amis.\n",
    "Affectueux, protecteur, gourmand\n"
);

var especeBugsyface = EspeceMonstre(
    10,
    "Bugsyface",
    "Insecte",
    10,
    13,
    8,
    7,
    13,
    45,
    7.0,
    11.0,
    6.5,
    8.0,
    11.5,
    21.0,
    "Insecte à carapace luisante, se déplace par bonds et vibre des antennes.",
    "Sa carapace devient plus dure après chaque mue.",
    "Travailleur, sociable, infatigable"
);

var especeGalum = EspeceMonstre(
    13,
    "Galum",
    "Minéral",
    12,
    15,
    6,
    8,
    12,
    55,
    9.0,
    13.0,
    4.0,
    6.5,
    10.5,
    13.0,
    "Golem ancien de pierre, yeux lumineux en garde.",
    "Peut rester immobile des heures comme une statue.",
    "Sérieux, stoïque, fiable"
);

fun main(){
    println(changeCouleur("Hello","rouge"))
    joueur.afficheDetail()
    rival.afficheDetail()
    joueur.argents+=50
    joueur.afficheDetail()
    println(especeSpringleaf.afficheArt())
    println(especeSpringleaf.afficheArt(false))
    println(especeFlamkip.afficheArt())
    println(especeFlamkip.afficheArt(false))
    println(especeAquamy.afficheArt())
    println(especeAquamy.afficheArt(false))



}