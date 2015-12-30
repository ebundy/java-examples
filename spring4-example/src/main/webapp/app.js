(function() {
  var app = angular.module('gemStore', []);

  app.controller('StoreController', function(){
    this.products = gems;
  });

  var gems = [
    { name: 'Azuritex', 
      price: 110.50,
      images: [
				"images/gem-01.gif",
				"images/gem-03.gif",
				"images/gem-04.gif"
			  ]
      },
    { name: 'Bloodstone', price: 22.90 },
    { name: 'Zircon', price: 1100 },
  ];
})();
