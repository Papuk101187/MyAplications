<#import "macros/forms.ftl" as f>
<#import "macros/page.ftl" as p>



<!-- страница для продавца  -->
<#if (usertype=="seller")>
    <@p.seller>
    </@p.seller>
</#if>

<!-- страница для клиента  -->

<#if (usertype=="customer")>
    <@p.customer>
    </@p.customer>
</#if>