function miPiace(recensioneId){
	$.ajax({
			url: "/miPiaceAction",
			data: {"recensione" : recensioneId},
			type: "post",
			success : function(risposta){
				var id = "like_" + recensioneId;
				var likeSpan = document.querySelector("#" + id);
				likeSpan.innerHTML = risposta;
			},
			fail : function(){
				//errore
			}
		});
}

function nonMiPiace(recensioneId){
		$.ajax({
			url: "XXXX",
			data: {XXXX},
			type: "post",
			success : function(risposta){
				
			}
		});
}
