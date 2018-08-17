package inventory

import static specs.Properties.tssp_base_url

class BranchEntity {

    //specs.Properties
    String name
    String object_id
    String site_id


    //URLs
    String devices_url = "$tssp_base_url/branch?id=$object_id&action=devices"
    String general_url = "$tssp_base_url/branch?id=$object_id&action=general"
    String dhcp_url = "$tssp_base_url/branch?id=$object_id&action=dhcpConfiguration"
    String portforward_url = "$tssp_base_url/branch?id=$object_id&action=accessFromInternet"
    String priority_url = "$tssp_base_url/branch?id=$object_id&action=trafficPriority"
    String dns_url = "$tssp_base_url/branch?id=$object_id&action=dynDns"
    String antispam_url = "$tssp_base_url/branch?id=$object_id&action=antispamService"
    String traffic_url = "$tssp_base_url/branch?id=$object_id&action=trafficManagement"

}