<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Javascript消除游戏</title>
<script type="text/javascript" src="https://www.chhblog.com/html/script/jquery-3.1.1.min.js"></script> <style>
div{ margin:0; padding:0;}
.board{ width:500px; height:500px; border:1px solid #ccc;  position: relative; margin:50px auto 0 auto;}
.board div{ width:40px; height:40px; position: absolute; color:white; cursor:pointer;}
.act{ width:500px; margin:0 auto; text-align: center; margin-top:20px;}
</style>
</head>
<body>

<div id="g_board" class="board">					
</div>
<div class="act">
<a href="https://www.shdssht.com//">点我有惊喜哦</a>
<input style="color:red;font-size: 24px ;" type="button" value="开始游戏" id="start_btn" />
<input style="color:red;font-size: 24px ;" type="button" value="重新开始" id="restart_btn" />
分数：<span id="score">0</span>
时间：<span id="time">0</span>
</div>

<script type="text/javascript">
( function() {
	var Y = 10;
	var X = 10;
	var gameBoard = [];
	var gridCount = 0;

	var Grid = function() {
		var num;
		var state;
		var tempState;
		var id = ++gridCount;
		var moveCount = 0;
		var isNew = true;

		this.isNew = function() {
			return isNew;
		}

		this.clearNew = function() {
			isNew = false;
		}

		this.addMoveCount = function() {
			moveCount++;
		}

		this.getMoveCount = function() {
			return moveCount;
		}

		this.setMoveCount = function( c ) {
			moveCount = c;
		}

		this.clearMoveCount = function() {
			moveCount = 0;
		}

		this.moveable = function() {
			return moveCount > 0 || isNew;
		}

		this.writeState = function() {
			tempState && ( state = tempState );
		}

		this.isRemoveable = function() {
			return state == 1;
		}

		this.setTempState = function() {
			tempState = 1;
		}

		this.restoreTempState = function() {
			tempState = 0;
		}
		
		this.setNumber = function( n ) {
			num = n;
		}

		this.getNumber = function() {
			return num;
		}

		this.getID = function() {
			return id;
		}
	}
	
	function GridGameStruct() {

		var statistics = {};

		var addStatistics = function( length ) {
			if( statistics[ length ] ) {
				statistics[ length ] += 1;
			} else {
				statistics[ length ] = 1;
			}
		}

		this.getStatistics = function() {
			return statistics;
		}

		this.initBoard = function() {
			for( var i = 0; i < Y; i++ ) {
				gameBoard[ i ] =[];
				for(  var j = 0; j < X; j++ ) {
					gameBoard[ i ][ j ] = randomGrid();		
				}
			}
		}

		var getContinuous = function( list, field ) {
			var result = [];
			var tempResult = [];
			var prev;
			for( var i = 0; i < list.length; i++ ) {
				var item = list[ i ];
				if( prev == null ) {
					prev = item;
					tempResult.push( item );
				} else {
					if( item[ field ] - prev[ field ] == 1 ) {
						tempResult.push( item );
					} else {
						if( tempResult.length >= 3 ) {
							result = result.concat( tempResult );
							addStatistics( tempResult.length );
						}
						tempResult = [ item ];
					}
					prev = item;
				}
			}

			if( tempResult.length >= 3 ) {
				result = result.concat( tempResult );
				addStatistics( tempResult.length );				
			}

			return result;
		}

		var getContinuousGroup = function( list ) {
			var groupsX = {};
			var groupsY = {};
			for( var i = 0; i < list.length; i++ ) {
				var item = list[ i ];
				//横
			    if( !groupsX[ item.i ] ) {
			    	groupsX[ item.i ] = [];
			    }
			    groupsX[ item.i ].push( item );
			    //纵
			    if( !groupsY[ item.j ] ) {
			    	groupsY[ item.j ] = [];
			    }
			    groupsY[ item.j ].push( item );			    
			}

			var results = [];

			for( var key in groupsX ) {
				var array = groupsX[ key ];
				array.sort( function( a, b ) {
					return a.j - b.j;
				} );
				results = results.concat( getContinuous( array, 'j' ) );
			}

			for( var key in groupsY ) {
				var array = groupsY[ key ];
				array.sort( function( a, b ) {
					return a.i  - b.i;
				} );
				results = results.concat( getContinuous( array, 'i' ) );
			}

			return results;
		}

		var group = function( gameBoard ) {
			statistics = {};
			var groups = {};
			for( var i = 0; i < Y; i++ ) {
				for(  var j = 0; j < X; j++ ) {
					var grid = gameBoard[ i ][ j ];
					if( !groups[ grid.getNumber() ] ) {
						groups[ grid.getNumber() ] = [];
					}
					groups[ grid.getNumber() ].push( {
						grid:  grid,
						i: i, j: j 
					} );
				}
			}			
			return groups;
		}

		this.remove = function() {
			var groups = group( gameBoard );
			var gridMap = {};
			var grids = [];
			for( var key in groups ) {
				var list = getContinuousGroup( groups[ key ] );
				for( var i = 0; i < list.length; i++ ) {
					var item = list[ i ];
					var grid = item.grid; 
					grid.setTempState();
					grid.writeState();
					gridMap[ grid.getID() ] =  grid;
					gameBoard[ item.i ][ item.j ] = null;
				}
			}

			for( var key in gridMap ) {
				grids.push( gridMap[ key ] );
			}
			return grids;
		} 

		this.testContinuable = function( board, pos, testPos ) {
			if( testPos.i < 0 || testPos.i > Y - 1 || testPos.j < 0 || testPos.j > X - 1 ) {
				return false;
			}
			var grid = board[ pos.i ][ pos.j ];
			var testGrid = board[ testPos.i ][ testPos.j ];

			board[ pos.i ][ pos.j ] = testGrid;
			board[ testPos.i ][ testPos.j ] = grid;

			var groups = group( board );
			for( var key in groups ) {
				var list = getContinuousGroup( groups[ key ] );
				if( list.length > 0 ) {
					board[ testPos.i ][ testPos.j ] = testGrid;
					board[ pos.i ][ pos.j ] = grid;
					return true;
				}
			}
			board[ testPos.i ][ testPos.j ] = testGrid;
			board[ pos.i ][ pos.j ] = grid;			
			return false;
		}

		this.continuable = function() {
			var posClone = [];
			for( var i = 0; i < Y; i++ ) {
				posClone[ i ] = [];
				for(  var j = 0; j < X; j++ ) {
				   posClone[ i ][ j ] = gameBoard[ i ][ j ];
				}
			}				
			//log( posClone );

			for( var i = 0; i < Y; i++ ) {
				for(  var j = 0; j < X; j++ ) {
					var leftPos = { i: i, j: j - 1 };
					var rightPos = { i: i, j: j + 1 };
					var topPos = { i: i - 1, j: j };
					var bottomPos = { i: i + 1, j: j };
					if( this.testContinuable( posClone, { i: i, j: j }, leftPos ) ||
						 	this.testContinuable( posClone, { i: i, j: j }, rightPos ) ||
						    this.testContinuable( posClone, { i: i, j: j }, topPos ) ||
						    this.testContinuable( posClone, { i: i, j: j }, bottomPos ) ) {
						return true;
					} 
				}
			}					
			return false;
		}

		this.fillGameBoard = function() {
			for( var i = 0; i < Y; i++ ) {
				for( var j = 0; j < X; j++ ) {
					if( gameBoard[ i ][ j ] != null ) {
						gameBoard[ i ][ j ].clearNew();
						gameBoard[ i ][ j ].clearMoveCount();
					}
				}
			}	

			var pos =this.getFirstEmptyPos();
			var colMoveCount = {};
			while( pos ) {
				if( colMoveCount[ pos.j ] ) {
					colMoveCount[ pos.j ] ++ ;
				} else {
					colMoveCount[ pos.j ] = 1;
				}
				
				var index = pos.i;
				while( index > 0 ) {
					var grid =  gameBoard[ index - 1 ][ pos.j ];
					grid.addMoveCount();
					gameBoard[ index ][ pos.j ] = grid;
					index--;
				}
				gameBoard[ 0 ][ pos.j ] = randomGrid();
				gameBoard[ 0 ][ pos.j ].setMoveCount( colMoveCount[ pos.j ] - 1 );

				pos = this.getFirstEmptyPos();
			}
		}

		this.getFirstEmptyPos = function() {
			for( var i = 0; i < Y; i++ ) {
				for( var j = 0; j < X; j++ ) {
					if( gameBoard[ i ][ j ] == null ) {
						return { i: i, j: j };
					}
				}
			}		
		}

		function getYGrids( pos ) {	
			var grids = [];
			for( var i = 0; i < Y; i++ ) {
				grids.push( gameBoard[ i ][ pos.j ] );
			}
			return grids;
		}

		function getPos( gridID ) {
			for( var i = 0; i < Y; i++ ) {
				for( var j = 0; j < X; j++ ) {
					if( gameBoard[ i ][ j ].getID() == gridID ) {
						return {
							i: i, j: j
						}
					}
				}
			}
		}

		this.getPos = function( gridID ) {
			return getPos( gridID );
		}

		function randomGrid() {
		    var r = Math.floor( Math.random() * 10 );
			var g = new Grid();
			g.setNumber( r );
			return g; 	
		}

		this.swapGrid = function( gridID1, gridID2 ) {
			var pos1 = getPos( gridID1 );
			var pos2 = getPos( gridID2 );
			var grid1 = gameBoard[ pos1.i ][ pos1.j ];
			var grid2 = gameBoard[ pos2.i ][ pos2.j ];
			gameBoard[ pos1.i ][ pos1.j ] = grid2;
			gameBoard[ pos2.i ][ pos2.j ] = grid1;
		}
	}

	function log( gameBoard ) {
		var html = '';
		for( var i = 0; i < Y; i++ ) {
			for( var j = 0; j < X; j++ ) {
				if( gameBoard[ i ][ j ] == null ) {
					html += ' <span style="color:red;">x</span> ';
				} else {
					html += ' ' + gameBoard[ i ][ j ].getNumber() + ' ';
				}
			}
			html += "<br/>";
		}
		document.getElementById( 'log_html' ).innerHTML = ( html + '<br/><br/>' );		
	}

	function GridGameUI() {
		var colorMap = {
			0: '#000', 1: '#f00', 2: 'blue', 3: 'green', 4: '#ccc', 5: '#da0add', 6: 'yellow',
			7: 'brown', 8: 'purple', 9: 'Orange'
		}

		var game = new GridGameStruct();
		var placeholder;
		var selectedGrid;
		var self = this;

		var isGameOver = false;
		var pause = false;
		//分数
		var score = 0;
		//连击数
		var continuousCount = 0;

		this.onRemove = new Function;

		this.gameOver = function() {
			isGameOver = true;
		}

		this.pause = function( state ) {
			pause = state;
		}

		this.render = function( p ) {
			placeholder = p;
			initUI();
		}

		var bindEvent = function() {
			var gridUIs = document.getElementById( placeholder ).getElementsByTagName( 'div' );
			for( var i = 0; i < gridUIs.length; i++ ) {
				gridUIs[ i ].onclick = function() {
					if( isGameOver ) {
						alert( '游戏结束' );
						return;
					} 

					if( pause ) {
						alert( '游戏处于暂停中' );
						return;
					}
					continuousCount = 0;
					var gridID = this.id.replace( /^grid_/, '' );
					if( selectedGrid && gridID != selectedGrid ) {
						var gridUI1 = $( '#grid_' + selectedGrid );
						var gridUI2 = $( '#grid_' + gridID );
						var gridUI1Offset = { left: gridUI1.css( 'left' ), top: gridUI1.css( 'top' ) };
						var gridUI2Offset = { left: gridUI2.css( 'left' ), top: gridUI2.css( 'top' ) };
						var pos1 = game.getPos( selectedGrid );
						var pos2 = game.getPos( gridID );

						if( Math.abs( pos1.i - pos2.i ) == 1 && Math.abs( pos1.j - pos2.j ) == 0 ||
						    Math.abs( pos1.i - pos2.i ) == 0 && Math.abs( pos1.j - pos2.j ) == 1 ) {
							gridUI1.animate( gridUI2Offset, 300 );
								gridUI2.animate( gridUI1Offset, 300, function() {
									if( game.testContinuable( gameBoard, pos1, pos2 ) ) {
										game.swapGrid( selectedGrid, gridID );
										nextStep();
									} else {
										gridUI1.animate( gridUI1Offset, 300 );
										gridUI2.animate( gridUI2Offset, 300 );
									}
									selectedGrid = null;
								} );	
								$( '#grid_' + selectedGrid ).css( 'opacity', 1 );
						} else {
							$( '#grid_' + selectedGrid ).css( 'opacity', 1 );
							selectedGrid = gridID;		
							$( '#grid_' + selectedGrid ).css( 'opacity', 0.5 );					
						}			
					} else {
						selectedGrid = gridID;
						$( this ).css( 'opacity', 0.5 );
					}
				}
			}			
		}



		var animate = function() {
			var finshCount = 0;
			var moveableGridCount = 0;
			for( var i = 0; i < Y; i++ ) {
				for( var j = 0; j < X; j++ ) {
					var grid = gameBoard[ i ][ j ];
					if( grid.moveable() ) {
						moveableGridCount++;
						if( grid.isNew() ) {
							genNewGridHtml( i, j, grid );
							grid.addMoveCount();
						}
						var gridUI = $( '#grid_' + grid.getID() );
						gridUI.animate( { top: '+=' + grid.getMoveCount() * 50 }, 500, function() {
							finshCount++;
							if( finshCount == moveableGridCount ) {
								nextStep();
							}
						} );
					}
				}
			}
			if( moveableGridCount == 0 ) {
				nextStep();
			}
		}

		var computeScore = function() {
			var statistics = game.getStatistics();
			var currScore = 0;
			for( var key in statistics ) {
				currScore += parseInt( key ) * parseInt( statistics[ key ] );
			}
			
			if( currScore > 0 ) {
				continuousCount++;
				currScore += ( continuousCount - 1 ) * 10;
				score += currScore;
				if( typeof( self.onRemove ) == 'function' ) {
					self.onRemove( currScore, score );
				}
			}
		}

		var nextStep = function() {
			var grids = game.remove();	
			computeScore();		

			for( var i = 0; i < grids.length; i++ ) {
				var grid = $( '#grid_' + grids[ i ].getID() );
				grid
				.css( { 'z-index': '999', 'border': 'none' } )
				.animate( { 'width': '+=32', 'height': '+=32', left: '-=8', top: '-=8' }, 200 );
			}

			window.setTimeout( function() {
				genHTML();
				var firstPos = game.getFirstEmptyPos();
				if( firstPos ) {
					game.fillGameBoard();
					animate();
				} else {
				  if( !game.continuable() ) {
				   		initUI();
				   }
				}
			}, 300 );		
		}

		var genHTML = function() {
			var html = '';
			for( var i = 0; i < Y; i++ ) {
				for( var j = 0; j < X; j++ ) {
					var grid = gameBoard[ i ][ j ];
					var left = j * 50;
					var top = i * 50; 
					if( grid != null ) {
						html += '<div id="grid_'+ grid.getID() +'" style="background:'+ colorMap[ grid.getNumber() ] +'; left: '+ left +'px; top: '+ top +'px; border:5px '+ colorMap[ grid.getNumber() ] +' outset"><!--'+ grid.getMoveCount() + ( grid.isNew() ? '' : '' ) +'--> </div>';
					}
				}
			} 		
			$( '#' + placeholder ).html( html );	
			bindEvent();
		}

		var genNewGridHtml = function( i, j, grid ) {
			var left = j * 50;
			var top = - ( grid.getMoveCount() - i + 1 ) * 50;
			var html = '<div id="grid_'+ grid.getID() +'"></div>';
			var element = $( html );
			$( '#' + placeholder ).append( element );
			element.css( { left: left, top: top, background: colorMap[ grid.getNumber() ], border: '5px ' + colorMap[ grid.getNumber() ] +' outset' } );
		}

		var initUI = function() {
			game.initBoard();
			for( var i = 0; i < Y; i++ ) {
				for( var j = 0; j < X; j++ ) {
					var grid = gameBoard[ i ][ j ];
					grid.setMoveCount( Y - 1 );
				}
			}
			$( '#' + placeholder ).html( '' );
			animate();
		}

	}

window.onload = function() {
	var SECOND = 200;
	var isStart = false;
	var ui;
	var pause;
	var timer;
	var timecount = 0;
	var isGameOver = false;

	function timing() {
		if( isGameOver ) {
			window.clearInterval( timer );
			return;
		}
		timecount++;
		$( '#time' ).html( timecount + '秒' );
		if( timecount >= SECOND ) {
			isGameOver = true;
			ui.gameOver( isGameOver );
		}
	}

	$( '#start_btn' ).bind( 'click', function() {
		if( !isStart ) {
			ui = new GridGameUI();
			ui.onRemove = function( currScore, score ) {
				$( '#score' ).html( score );
			}
			ui.render( 'g_board' );
			isStart = true;			
			$( this ).val( '暂停游戏' );

			timer = window.setInterval( timing, 1000 );
		} else {
			if( isGameOver ) {
				alert( '游戏已结束，请点击重新开始按扭' );
				return;
			}
			if( pause ) {
				pause = false;
				$( this ).val( '暂停游戏' )
				timer = window.setInterval( timing, 1000 );
			} else {
				pause = true;
				$( this ).val( '取消暂停' );
				window.clearInterval( timer );
			}
			ui.pause( pause );
		}

	} );

	$( '#restart_btn' ).bind( 'click', function() {
		window.location.reload();
	} )
}

} )();

</script>

<div id="log_html"></div>

</body>
</html>