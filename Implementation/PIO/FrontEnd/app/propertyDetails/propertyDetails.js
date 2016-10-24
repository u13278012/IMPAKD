/*'use strict';*/
var app = angular.module('myApp', []);
app.controller('PropertyDetailsCtrl', ["$scope", "$window", "$http", function($scope, $window, $http) {

     
   
   $scope.getProfileID = function() 
    {

            var session  = localStorage.getItem("session");
            
            var propertyid  = localStorage.getItem("property");
            var encodedString = 'profileID=' +
            encodeURIComponent(session)+
            '&propertyid=' +
            encodeURIComponent(propertyid);
            //20285
           
        
            $http({
                method: 'POST',
                url: 'http://localhost:8080/BackEnd/rs/property/getPropertyDetails',
                data: encodedString,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                    var x2js = new X2JS();
                    var x = x2js.xml_str2json(response);
                    $scope.propertyresults = x;
<<<<<<< HEAD
                   console.log(x);
//                   alert("prop details succ");
=======
                   //console.log(x);
                   //alert("prop details succ");
>>>>>>> 2e8ade21409b5c7bd89c4f8a3ab4ad1159d9de5e

                }).
                error(function(response)
                {
<<<<<<< HEAD
//                     alert("prop details fail");
=======
                    // alert("prop details fail");
>>>>>>> 2e8ade21409b5c7bd89c4f8a3ab4ad1159d9de5e

                });
                //20285
                $http({
                method: 'GET',
                url: 'http://localhost:8080/BackEnd/rs/tr/getROI/'+session+'/'+propertyid,
                data: encodedString,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                    var x2js = new X2JS();
                    var arr = x2js.xml_str2json(response);
                  //  $scope.Array = arr;
                    $scope.ROI = [];
                    var l = arr.roi.array.length;
                    while (--l >= 0 )
                    $scope.ROI[l] = parseFloat(arr.roi.array[l]);
                    //console.log($scope.ROI);
                    $scope.show();
                }).
                error(function(response)
                {
                 
                        //alert("roi fails");

                });

        };
   $scope.getROI = function() 
   { 
     var d = new Date();
     var currentYear = d.getFullYear();
     $scope.Year = [];
     for(var x = 0; x < 20 ;x++){
      $scope.Year[x] = currentYear; 
      currentYear =currentYear+1;
     }
  };
    $scope.show = function () {
     $scope.getROI();
         var session  = localStorage.getItem("session");
             if (typeof(Storage) === "undefined") {
         alert("You're not logged in");
         //go to login
           
        }


		var chart = new CanvasJS.Chart("chartContainer",
		{
			title:{
				text: "ROI IN YEARS"
			},   
                        animationEnabled: true,  
			axisY:{ 
				title: "ROI %",
				includeZero: false                    
			},
			axisX: {
				title: "Years",
				interval: 1
			},
			toolTip: {
				shared: true,
				content: function(e){
					var body = new String;
					var head ;
					for (var i = 0; i < e.entries.length; i++){
						var  str = "<span style= 'color:"+e.entries[i].dataSeries.color + "'> " + e.entries[i].dataSeries.name + "</span>: <strong>"+  e.entries[i].dataPoint.y + "</strong>'' <br/>" ; 
						body = body.concat(str);
					}
					head = "<span style = 'color:DodgerBlue; '><strong>"+ (e.entries[0].dataPoint.label) + "</strong></span><br/>";

					return (head.concat(body));
				}
			},
			legend: {
				horizontalAlign :"center"
			},
			data: [
			{        
				type: "spline",
				showInLegend: true,
				name: "ROI%",
				dataPoints: [
				{ label: $scope.Year[0], y: $scope.ROI[0] },
				{ label: $scope.Year[1], y: $scope.ROI[1]},
				{ label: $scope.Year[2], y: $scope.ROI[2] },
				{ label: $scope.Year[3], y: $scope.ROI[3] },
				{ label: $scope.Year[4], y: $scope.ROI[4] },
				{ label: $scope.Year[5], y: $scope.ROI[5] },
				{ label: $scope.Year[6], y: $scope.ROI[6] },
				{ label: $scope.Year[7], y: $scope.ROI[7] },
				{ label: $scope.Year[8], y: $scope.ROI[8]},
				{ label: $scope.Year[9], y: $scope.ROI[9] },
                                { label: $scope.Year[10], y: $scope.ROI[10] },
				{ label: $scope.Year[11], y: $scope.ROI[11]},
				{ label: $scope.Year[12], y: $scope.ROI[12] },
				{ label: $scope.Year[13], y: $scope.ROI[13] },
				{ label: $scope.Year[14], y: $scope.ROI[14] },
				{ label: $scope.Year[15], y: $scope.ROI[15] },
				{ label: $scope.Year[16], y: $scope.ROI[16] },
				{ label: $scope.Year[17], y: $scope.ROI[17] },
				{ label: $scope.Year[18], y: $scope.ROI[18]},
				{ label: $scope.Year[19], y: $scope.ROI[19] }
				]
			} 
			],
          legend :{
            cursor:"pointer",
            itemclick : function(e) {
              if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
				e.dataSeries.visible = false;
              }
              else{
				e.dataSeries.visible = true;
              }
              chart.render();
            }
          }
          
		});

chart.render();
 // document.getElementById("viewGraphPD").style.color ="white"; 
 //document.getElementById("viewGraphPD").style.backgroundColor ="teal";
             
//document.getElementById("linkTOProperty").style.color ="teal";
             
};
    $scope.model = {
			propertyName: 'City Properties',
			tax: '21%',
			inflation: '5.5%',
			anualMantainance: '6000.00',
                        anualCostIncrease: '10%',
				
                        interestRate: '10%',
			depositeASPercentage: '21%',
		        propertyValue: 'R500000.00',
                        numberOfYears: '30',
                
			 occupancyRate: '11%',
		         agentCommission: 'R 17000.00',
		         rentalAmount: '5000.00'
                
                
				};
                                
   $scope.back = function()
   {
       localStorage.removeItem("property");
       window.location = "../home/home.html";
   }
                                
}]);