function sendHit(trackingId)
{
	$(function() {
        // Make a GET call to this site to retrieve info
        $.ajax({
            url : 'https://ipinfo.io/json',
            type : 'GET',
            dataType: 'json',

            success: function(ipInfo)
            {
                // Collect the IP data along with the tracking id
                // For now for the sake of simplicity we'll only take the IPv4 or IPv6 address.
                var hitInfo = {
                    "trackingId" : trackingId,
                    "hitDate" : new Date(),
                    "ip" : ipInfo['ip']
                }
                
                // Here we send the collected data to our server.
                $.ajax({
                    url: 'http://localhost:8080/hit',
                    dataType: "text json",
                    type: "POST",
                    data: hitInfo,
                });
            }
        });
	});
}