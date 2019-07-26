$(function(){
     $("#username_error_msg").hide();   
     $("#password_error_msg").hide();
     $("#kontakt_error_msg").hide();
     $("#adresa_error_msg").hide();
     $("#re_password_error_msg").hide();
     
     var error_username = false;
     var error_password = false;
     var error_re_password = false;
     var error_kontakt = false;
     var error_adresa = false;
     var error_kod = false;
     

     $("#username").focusout(function(){
         
        proveriUsername(); 
     });
     
     $("#password").focusout(function(){
         
        proveriPass(); 
     });
     
     $("#kontakt").focusout(function(){
         
        proveriKontakt(); 
     });
     
     $("#adresa").focusout(function(){
         
        proveriAdresu(); 
     });
     
     $("#re_password").focusout(function(){
         
        proveriPonovoUnetiPass(); 
     });
     
     $("#postanskiKod").focusout(function(){
         
        proveriPostanskiKod(); 
     });
     
     function proveriUsername(){
         var username_len = $("#username").val().length;
         
         if(username_len < 5 || username_len > 20){
             $("#username_error_msg").html("Username mora biti duzine izmedju 5 i 20 karaktera.")
             $("#username_error_msg").show();
             error_username = true;
         }else{
             $("#username_error_msg").hide(); 
         } 
     }
     
     function proveriPass(){
         var pass_len = $("#password").val().length;
         var pass = $("#password").val();
         if(pass_len < 8){
             $("#password_error_msg").html("Password ne sme biti kraci od 8 karaktera.");
             $("#password_error_msg").show();
             error_password = true;
         }else{
             $("#password_error_msg").hide(); 
         } 
         
         var upperCase= new RegExp('[A-Z]');
         var lowerCase= new RegExp('[a-z]');
         var numbers = new RegExp('[0-9]');
         
         if( !(pass.match(upperCase) && pass.match(lowerCase) && pass.match(numbers))){
             $("#password_error_msg").html("Password mora sadrzati barem jedno veliko slovo, barem jedno malo slovo i barem jedan broj i mora biti barem 8 karaktera");
             $("#password_error_msg").show();
             error_password = true;
             
         }
         else{
             $("#password_error_msg").hide();
             
         }     
     }
     

     function proveriKontakt(){
         var kontakt_len = $("#kontakt").val().length;
         var kontakt = $("#kontakt").val();
         if(kontakt_len < 6){
             $("#kontakt_error_msg").html("Minimalna duzina kontakt telefona je 6 brojeva.");
             $("#kontakt_error_msg").show();
             error_kontakt = true;
         }else{
             $("#kontakt_error_msg").hide(); 
         } 
        
         var numbers = new RegExp('[0-9]');

            if( kontakt.match(/^[0-9]+$/) == null ){
                $("#kontakt_error_msg").html("Kontakt telefon mora sadrzati samo brojeve, bez crtica i pluseva");
                $("#kontakt_error_msg").show();
                error_password = true;

            }
            else{
                $("#kontakt_error_msg").hide();

            }   
         
         
     }
     
     
     function proveriAdresu(){
         var adr_len = $("#adresa").val().length;
         if(adr_len < 4){
             $("#adresa_error_msg").html("Unesite vasu adresu.");
             $("#adresa_error_msg").show();
             error_adresa = true;
         }else{
             $("#adresa_error_msg").hide(); 
         } 

     }
     
     function proveriPonovoUnetiPass(){
         var pass = $("#password").val();
         var re_pass = $("#re_password").val();
         if(pass != re_pass){
             $("#re_password_error_msg").html("Unete lozinke se ne poklapaju.");
             $("#re_password_error_msg").show();
             $("#registerMe").hide();
             
             error_re_password = true;
         }else{
             $("#re_password_error_msg").hide();
             $("#registerMe").show();
         } 

     }
     
     
     function proveriPostanskiKod(){
         var kod = $("#postanskiKod").val();
         var kod_len = $("#postanskiKod").val().length;
        
            if(kod_len == 0){
                $("#kod_error_msg").html("Unesite postanski kod grada koji ste uneli.");
                $("#kod_error_msg").show();
                error_kod = true;
                
            }
            else{
                $("#kod_error_msg").hide();

            }   
         var numbers = new RegExp('[0-9]');

            if( kod.match(/^[0-9]+$/) == null ){
                $("#kod_error_msg").html("Postanski kod treba da sadrzi samo cifre.");
                $("#kod_error_msg").show();
                error_kod = true;

            }
            else{
                $("#kod_error_msg").hide();

            }   
 
     }
});




