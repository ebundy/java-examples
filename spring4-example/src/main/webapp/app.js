(function() {

	angular.module('logExample', []).controller('LogController',
			[ '$scope', '$log', function($scope, $log) {
				$scope.$log = $log;
				$scope.message = 'Hello World!';
			} ]);

	var app = angular.module('gemStore', []);

	app.controller('StoreController', function() {
		this.products = gems;
	});

	app.controller('PanelController', function() {

		this.selection = 1;

		this.selectTab = function(setTab) {
			this.selection = setTab;
			alert("setTab" + setTab);			
		};

		this.isSelected = function(isTab) {
			return this.selection === isTab;
		};

	});

	var gems = [
			{
				name : 'Azuritex',
				price : 110.50,
				isSuper : true,
				images : [ "images/gem-01.gif", "images/gem-03.gif",
						"images/gem-04.gif" ]
			}, {
				name : 'Bloodstone',
				price : 22.90
			}, {
				name : 'Zircon',
				price : 1100
			}, ];
})();
