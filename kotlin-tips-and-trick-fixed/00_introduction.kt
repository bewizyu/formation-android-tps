// TODO-1 : Null Safety : Réecrir le code Java suivant en kotlin en utilisant une seule condition if
// public void sendMessageToClient(
//    @Nullable Client client,
//    @Nullable String message,
//    @NotNull Mailer mailer
//  ) {
//    if (client == null || message == null) return;
//
//    PersonalInfo personalInfo = client.getPersonalInfo();
//    if (personalInfo == null) return;
//
//    String email = personalInfo.getEmail();
//    if (email == null) return;
//
//    mailer.sendMessage(email, message);

fun sendMessageToClient(
    client: Client?, message: String?, mailer: Mailer
){
    val email = client?.personalInfo?.email
    if(email != null && message != null){
        mailer.sendMessage(email,message)
    }
}

class Client (val personalInfo: PersonalInfo?)
class PersonalInfo (val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}


// TODO-2 : Utiliser les named arguments pour plus de lisibilité

// HINT :
// fun joinToString(
//    separator: String = ", ",
//    prefix: String = "",
//    postfix: String = "",
//    /* ... */
//): String
// Peut etre appeler sur une collection.
// modifier le resultat pour avoir un format JSON en sortie e.g., "[a, b, c]"

fun joinOptions(options: Collection<String>) = options.joinToString(prefix = "[", postfix = "]")