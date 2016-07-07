DESCRIPTION = "Audio/video SIP-based IP phone"
HOMEPAGE = "http://www.linphone.org/?lang=us"
LICENSE = "GPLv2"
PR="r0"

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://download-mirror.savannah.gnu.org/releases/linphone/3.6.x/sources/linphone-${PV}.tar.gz"
SRC_URI[md5sum] = "f59b99ec2501ebbb02969c885be4c4c5"
SRC_URI[sha256sum] = "05ba81223e9378c3bce8d33080213b9925af49bd9623cd9004eb3dd22ca9d2a0"

S = "${WORKDIR}/linphone-${PV}"

DEPENDS = "intltool readline libosip2 libexosip2 speex alsa-lib"

EXTRA_OECONF = " \
        --enable-alsa \
        --disable-zrtp \
        --disable-ipv6 \
        --disable-strict \
        --disable-ssl \
        --disable-ssl-hmac \
        --disable-video \
        --enable-gtk_ui=no \
        --enable-console_ui=yes \
"

FILES_${PN}-bin = "${bindir}/mediastream ${bindir}/linphone ${bindir}/linphonecsh"

FILES_${PN} += " ${libdir}/mediastreamer/plugins ${datadir}/images/nowebcamCIF.jpg"

do_configure_prepend() {
    sh autogen.sh
    oe_runconf
    exit
}

inherit autotools-brokensep pkgconfig gettext