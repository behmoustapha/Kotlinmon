package monstre
import dresseur.Entraineur
import kotlin.math.pow
import kotlin.math.roundToInt
import java.io.File
import kotlin.math.max
import monstre.EspeceMonstre

class IndividuMonstre(
    var id: Int,
    var nom: String,
    var espece: EspeceMonstre,
    var entraineur: Entraineur? = null,
    expInit: Double
) {
    var niveau: Int = 1
    var attaque: Int = espece.baseAttaque + (-2..2).random()
    var defense: Int = espece.baseDefense + (-2..2).random()
    var vitesse: Int = espece.baseVitesse + (-2..2).random()
    var attaqueSpe: Int = espece.baseAttaqueSpe + (-2..2).random()
    var defenseSpe: Int = espece.baseDefenseSpe + (-2..2).random()
    var pvMax: Int = espece.basePv + (-5..5).random()
    var potentiel: Double = (5..20).random() / 10.0
    var exp: Double = 0.0
        get() = field
        set(value){
            field = value
            var estNiveau1: Boolean = (if(niveau == 1) true else false)
            while(field >= palierExp(niveau)){
                levelUp()
                if (estNiveau1 == false){
                    println("Le monstre  est maintenant niveau ${this.niveau} !")
                }
            }
        }

    var pv: Int = pvMax
        get() = field
        set(nouveauPv){
            field = (if (nouveauPv < 0 ) 0 else if (nouveauPv > pvMax) pvMax else nouveauPv)
        }

    init {
        this.exp = expInit // applique le setter et déclenche un éventuel level-up
    }

    fun palierExp(niveau: Int): Double{
        /**
         * Calcule l'expérience totale nécessaire pour atteindre un niveau donné.
         *
         * @param niveau Niveau cible.
         * @return Expérience cumulée nécessaire pour atteindre ce niveau.
         */

        var result: Double =100 * (niveau-1).toDouble().pow(2.0)

        return result
    }


    fun levelUp(){
        this.niveau += 1
        this.attaque += (espece.modAttaque.roundToInt() * this.potentiel.roundToInt()) + (-2..2).random()
        this.defense += (espece.modDefense.roundToInt() * this.potentiel.roundToInt()) + (-2..2).random()
        this.vitesse += (espece.modVitesse.roundToInt() * this.potentiel.roundToInt()) + (-2..2).random()
        this.attaqueSpe += (espece.modAttaqueSpe.roundToInt() * this.potentiel.roundToInt()) + (-2..2).random()
        this.defenseSpe += (espece.modDefenseSpe.roundToInt() * this.potentiel.roundToInt()) + (-2..2).random()
        this.pvMax += (espece.modPv.roundToInt() * this.potentiel.roundToInt()) + (-5..5).random()
    }

    fun attaquer(cible: monstre.IndividuMonstre){
        /**
         * Attaque un autre [IndividuMonstre] et inflige des dégâts.
         *
         * Les dégâts sont calculés de manière très simple pour le
        moment :
         * `dégâts = attaque - (défense / 2)` (minimum 1 dégât).
         *
         * @param cible Monstre cible de l'attaque.
         */
        var degatBrut = this.attaque
        var degatTotal = degatBrut - (this.defense / 2)
        if (degatTotal < 1){
            var degatTotal = 1
        }
        var pvAvant = cible.pv
        cible.pv -= degatTotal
        var pvApres = cible.pv
            println("${this.nom} inflige ${(pvAvant - pvApres)} dégats à ${cible.nom}")
    }

    fun renommer(){
        /**
         * Demande au joueur de renommer le monstre.
         * Si l'utilisateur entre un texte vide, le nom n'est pas
        modifié.
         */
        print("Renommer ${this.nom} ? Oui/Non: ")
        var answ = readln()
        if (answ.lowercase() == "oui"){
            print("Nouveau nom: ")
            var nouveauNom = readln()
            this.nom = nouveauNom

        }
    }

    fun afficheDetail(){
        var artLine = ""
        var detailLine = ""
        var test = espece.afficheArt()
        var artLines: List<String> = test.lines()
        var details: MutableList<String> = mutableListOf<String>(
            "Nom: ${this.nom} Niveau: ${this.niveau}",
            "Exp: ${this.exp}",
            "Pv: ${this.pv}/${this.pvMax}",
            "Atq: ${this.attaque} Def: ${this.defense} Vitesse: ${this.vitesse}",
            "AtqSpe: ${this.attaqueSpe} DefSpe: ${this.defenseSpe}"
        )
        var maxArtWidth: Int = artLines.size
        var maxLines = max(artLines.size, details.size)
        for (i in 0..(maxLines - 1)) {
            if (i < artLines.size) {
                var artLine = artLines[i]
            } else {
                var artLine = ""
            }
            if (i < details.size) {
                var detailLine = details[i]
            } else {
                var detailLine = ""
            }
            var paddedArt = artLine.padEnd(maxArtWidth + 4)
            println(paddedArt + detailLine)
        }

    }

}