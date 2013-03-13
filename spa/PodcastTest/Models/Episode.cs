﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PodcastTest.Controllers
{
    public class Episode
    {
        public int? Id { get; set; }

        public string Title { get; set; }

        public string Description { get; set; }

        public string AudioUri { get; set; }

        public bool ListenedTo { get; set; }
    }
}