(function() {
		
	
	const url2 = '/getAllDemandeDevis'; 
	console.log("AAAAAAAAAAAAA");
	
	fetch(url2) 
	.then(function(response) {
	
		return response.json();

		
	})
	.then(function(response){
								
		var element = document.getElementById('list-demandesdevis'); 	
		
		var tblBody = document.createElement("tbody");
		
		for(var j=0; j<response.length;j++){
			
			
			row = document.createElement("tr");
			row.setAttribute("id", j); 
			
		
				var para1 = document.createElement("td");
				para1.innerHTML = response[j].id; 				
				row.appendChild(para1);
				
				var para2 = document.createElement("td");
				para2.innerHTML = response[j].nom; 
				row.appendChild(para2);
				
				var para3 = document.createElement("td");
				para3.innerHTML = response[j].telephone; 
				row.appendChild(para3);
				
				var para4 = document.createElement("td");
				para4.innerHTML = response[j].email; 
				row.appendChild(para4);
				
				var para5 = document.createElement("td");
				para5.innerHTML = response[j].adresse; 
				row.appendChild(para5);
				
				var para6 = document.createElement("td");
				para6.innerHTML = response[j].code_postal; 
				row.appendChild(para6);
				
				var para7 = document.createElement("td");
				para7.innerHTML = response[j].information; 
				row.appendChild(para7);
	
				var btn1 = document.createElement("button");
				btn1.innerHTML = "Confirmer";                 
				row.appendChild(btn1); 
				
				btn1.onclick = function(e){
	
					const url3 = '/enregistrerClient';
					
					$(document).ready(function(){
						
						$('#'+e.target.parentNode.id).remove();

					});
					
					
					const body = JSON.stringify(response[parseInt(e.target.parentNode.id)]);
					console.log(response[parseInt(e.target.parentNode.id)]);
										
					fetch(url3, {
						method: "POST",
						body: body,
						headers: {
							'Content-Type': 'application/json'
						}
					}).then(response => {
						if (response.ok) {
							response.json()
							.then(console.log)
							.catch(error => {
								console.error(error);
							});
						} else {
							console.error('server response : ' + response.status);
						}
					}).catch(error => {
						console.error(error);
					});
					
										
				};
								
				var btn2 = document.createElement("button");
				btn2.innerHTML = "Supprimer";                   
				row.appendChild(btn2); 
				
				btn2.onclick = function(e){
					
					const url4 = '/supprimerDemandeDevis';
					
					$(document).ready(function(){
						
						$('#'+e.target.parentNode.id).remove();

					});
					
					const body = JSON.stringify(response[parseInt(e.target.parentNode.id)]);
					console.log(response[parseInt(e.target.parentNode.id)]);
										
					fetch(url4, {
						method: "POST",
						body: body,
						headers: {
							'Content-Type': 'application/json'
						}
					}).then(response => {
						if (response.ok) {
							response.text()
							.then(console.log)
							.catch(error => {
								console.error(error);
							});
						} else {
							console.error('server response : ' + response.status);
						}
					}).catch(error => {
						console.error(error);
					});															
				};
						
			tblBody.appendChild(row);
			
		}
		 element.appendChild(tblBody);	 
		 
	});
		
	
})();
