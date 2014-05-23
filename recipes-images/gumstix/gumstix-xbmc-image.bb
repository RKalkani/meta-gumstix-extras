DESCRIPTION = "A Gumstix image featuring XBMC and hardware acceleration."

require gumstix-console-image.bb

IMAGE_INSTALL += " \
    gst-plugins-base-meta \
    gst-plugins-good-meta \
    xbmc \
"

IMAGE_INSTALL_duovero += " \
    sgx \
    opengles \
"

IMAGE_INSTALL_overo += " \
    omap3-sgx-modules-x11 \
    libgles-omap3-x11 \
    omapfbplay \
    gstreamer-ti \
"

# https://github.com/balister/meta-xilinx/commit/8b66cb1edb65c34c332888e907aec4333422af6b
#setenv mem 'mem=96M@0x80000000 mem=384M@0x88000000'
#setenv mpurate 800
#setenv mmcargs 'setenv bootargs console=${console} mpurate=${mpurate} vram=${vram} omapfb.mode=dvi:${dvimode} omapfb.debug=y omapfb.vram=${fbvram} omapdss.def_disp=${defaultdisplay} ${mem} root=${mmcroot} rootfstype=${mmcrootfstype}'
