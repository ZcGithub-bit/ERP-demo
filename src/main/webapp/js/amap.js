
function showMap (id,lng,lat){
	var mapObj = new AMap.Map(id);
	var marker = new AMap.Marker({
		id:"m23",
		position:new AMap.LngLat(lng,lat),
		icon:"http://api.amap.com/webapi/static/Images/marker_sprite.png"//marker图标，直接传递地址url
	});
	mapObj.setCenter(new AMap.LngLat(lng,lat));
	mapObj.addOverlays(marker);
}
function findLngLat (id) {
	var mapObj = new AMap.Map(id);
	mapObj.bind(mapObj,"click",function (e) {
		alert("精度:"+e.lnglat.lng+"维度:"+e.lnglat.lat);
	});
}