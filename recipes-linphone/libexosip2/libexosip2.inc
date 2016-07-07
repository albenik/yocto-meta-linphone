DESCRIPTION = "The eXtended osip library"
LICENSE = "GPLv2"

SRC_URI = "http://download.savannah.gnu.org/releases/exosip/libeXosip2-${PV}.tar.gz"
S = "${WORKDIR}/libeXosip2-${PV}"

DEPENDS = "libosip2 openssl"

EXTRA_OECONF += "--enable-openssl"

PACKAGES += "${PN}-utils"

RDEPENDS_${PN}-dev += "libosip2-dev openssl-dev"

FILES_${PN}-utils += "${bindir}/sip_reg*"
